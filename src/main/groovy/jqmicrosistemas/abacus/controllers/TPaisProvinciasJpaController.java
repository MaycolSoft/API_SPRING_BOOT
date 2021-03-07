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
import jqmicrosistemas.abacus.model.TPaisProvincias;

/**
 *
 * @author Maycol
 */
public class TPaisProvinciasJpaController implements Serializable {

    public TPaisProvinciasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TPaisProvincias TPaisProvincias) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TPaisProvincias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TPaisProvincias TPaisProvincias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPaisProvincias = em.merge(TPaisProvincias);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TPaisProvincias.getFIdrecord();
                if (findTPaisProvincias(id) == null) {
                    throw new NonexistentEntityException("The tPaisProvincias with id " + id + " no longer exists.");
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
            TPaisProvincias TPaisProvincias;
            try {
                TPaisProvincias = em.getReference(TPaisProvincias.class, id);
                TPaisProvincias.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TPaisProvincias with id " + id + " no longer exists.", enfe);
            }
            em.remove(TPaisProvincias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TPaisProvincias> findTPaisProvinciasEntities() {
        return findTPaisProvinciasEntities(true, -1, -1);
    }

    public List<TPaisProvincias> findTPaisProvinciasEntities(int maxResults, int firstResult) {
        return findTPaisProvinciasEntities(false, maxResults, firstResult);
    }

    private List<TPaisProvincias> findTPaisProvinciasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TPaisProvincias.class));
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

    public TPaisProvincias findTPaisProvincias(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TPaisProvincias.class, id);
        } finally {
            em.close();
        }
    }

    public int getTPaisProvinciasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TPaisProvincias> rt = cq.from(TPaisProvincias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
