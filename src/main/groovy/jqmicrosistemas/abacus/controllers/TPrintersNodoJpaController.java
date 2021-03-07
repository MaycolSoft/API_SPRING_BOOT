/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jqmicrosistemas.abacus.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jqmicrosistemas.abacus.controllers.exceptions.NonexistentEntityException;
import jqmicrosistemas.abacus.model.TPrintersNodo;

/**
 *
 * @author Maycol
 */
public class TPrintersNodoJpaController implements Serializable {

    public TPrintersNodoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TPrintersNodo TPrintersNodo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TPrintersNodo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TPrintersNodo TPrintersNodo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPrintersNodo = em.merge(TPrintersNodo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TPrintersNodo.getFIdrecord();
                if (findTPrintersNodo(id) == null) {
                    throw new NonexistentEntityException("The tPrintersNodo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPrintersNodo TPrintersNodo;
            try {
                TPrintersNodo = em.getReference(TPrintersNodo.class, id);
                TPrintersNodo.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TPrintersNodo with id " + id + " no longer exists.", enfe);
            }
            em.remove(TPrintersNodo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TPrintersNodo> findTPrintersNodoEntities() {
        return findTPrintersNodoEntities(true, -1, -1);
    }

    public List<TPrintersNodo> findTPrintersNodoEntities(int maxResults, int firstResult) {
        return findTPrintersNodoEntities(false, maxResults, firstResult);
    }

    private List<TPrintersNodo> findTPrintersNodoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TPrintersNodo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TPrintersNodo findTPrintersNodo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TPrintersNodo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTPrintersNodoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TPrintersNodo> rt = cq.from(TPrintersNodo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
