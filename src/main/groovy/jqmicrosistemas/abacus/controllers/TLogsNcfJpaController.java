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
import jqmicrosistemas.abacus.model.TLogsNcf;

/**
 *
 * @author Maycol
 */
public class TLogsNcfJpaController implements Serializable {

    public TLogsNcfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TLogsNcf TLogsNcf) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TLogsNcf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TLogsNcf TLogsNcf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TLogsNcf = em.merge(TLogsNcf);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TLogsNcf.getFIdrecord();
                if (findTLogsNcf(id) == null) {
                    throw new NonexistentEntityException("The tLogsNcf with id " + id + " no longer exists.");
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
            TLogsNcf TLogsNcf;
            try {
                TLogsNcf = em.getReference(TLogsNcf.class, id);
                TLogsNcf.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TLogsNcf with id " + id + " no longer exists.", enfe);
            }
            em.remove(TLogsNcf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TLogsNcf> findTLogsNcfEntities() {
        return findTLogsNcfEntities(true, -1, -1);
    }

    public List<TLogsNcf> findTLogsNcfEntities(int maxResults, int firstResult) {
        return findTLogsNcfEntities(false, maxResults, firstResult);
    }

    private List<TLogsNcf> findTLogsNcfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TLogsNcf.class));
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

    public TLogsNcf findTLogsNcf(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TLogsNcf.class, id);
        } finally {
            em.close();
        }
    }

    public int getTLogsNcfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TLogsNcf> rt = cq.from(TLogsNcf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
