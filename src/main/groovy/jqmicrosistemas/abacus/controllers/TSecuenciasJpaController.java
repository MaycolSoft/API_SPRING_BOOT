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
import jqmicrosistemas.abacus.model.TSecuencias;

/**
 *
 * @author Maycol
 */
public class TSecuenciasJpaController implements Serializable {

    public TSecuenciasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TSecuencias TSecuencias) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TSecuencias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TSecuencias TSecuencias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TSecuencias = em.merge(TSecuencias);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TSecuencias.getFIdrecord();
                if (findTSecuencias(id) == null) {
                    throw new NonexistentEntityException("The tSecuencias with id " + id + " no longer exists.");
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
            TSecuencias TSecuencias;
            try {
                TSecuencias = em.getReference(TSecuencias.class, id);
                TSecuencias.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TSecuencias with id " + id + " no longer exists.", enfe);
            }
            em.remove(TSecuencias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TSecuencias> findTSecuenciasEntities() {
        return findTSecuenciasEntities(true, -1, -1);
    }

    public List<TSecuencias> findTSecuenciasEntities(int maxResults, int firstResult) {
        return findTSecuenciasEntities(false, maxResults, firstResult);
    }

    private List<TSecuencias> findTSecuenciasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TSecuencias.class));
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

    public TSecuencias findTSecuencias(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TSecuencias.class, id);
        } finally {
            em.close();
        }
    }

    public int getTSecuenciasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TSecuencias> rt = cq.from(TSecuencias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
