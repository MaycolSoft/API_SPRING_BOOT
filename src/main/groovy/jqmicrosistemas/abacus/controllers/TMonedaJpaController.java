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
import jqmicrosistemas.abacus.model.TMoneda;

/**
 *
 * @author Maycol
 */
public class TMonedaJpaController implements Serializable {

    public TMonedaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TMoneda TMoneda) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TMoneda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TMoneda TMoneda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TMoneda = em.merge(TMoneda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TMoneda.getFIdrecord();
                if (findTMoneda(id) == null) {
                    throw new NonexistentEntityException("The tMoneda with id " + id + " no longer exists.");
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
            TMoneda TMoneda;
            try {
                TMoneda = em.getReference(TMoneda.class, id);
                TMoneda.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TMoneda with id " + id + " no longer exists.", enfe);
            }
            em.remove(TMoneda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TMoneda> findTMonedaEntities() {
        return findTMonedaEntities(true, -1, -1);
    }

    public List<TMoneda> findTMonedaEntities(int maxResults, int firstResult) {
        return findTMonedaEntities(false, maxResults, firstResult);
    }

    private List<TMoneda> findTMonedaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TMoneda.class));
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

    public TMoneda findTMoneda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TMoneda.class, id);
        } finally {
            em.close();
        }
    }

    public int getTMonedaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TMoneda> rt = cq.from(TMoneda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
