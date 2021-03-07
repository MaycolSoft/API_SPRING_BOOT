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
import jqmicrosistemas.abacus.model.TRecargasTelefonicas;

/**
 *
 * @author Maycol
 */
public class TRecargasTelefonicasJpaController implements Serializable {

    public TRecargasTelefonicasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TRecargasTelefonicas TRecargasTelefonicas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TRecargasTelefonicas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TRecargasTelefonicas TRecargasTelefonicas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TRecargasTelefonicas = em.merge(TRecargasTelefonicas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TRecargasTelefonicas.getFIdrecord();
                if (findTRecargasTelefonicas(id) == null) {
                    throw new NonexistentEntityException("The tRecargasTelefonicas with id " + id + " no longer exists.");
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
            TRecargasTelefonicas TRecargasTelefonicas;
            try {
                TRecargasTelefonicas = em.getReference(TRecargasTelefonicas.class, id);
                TRecargasTelefonicas.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TRecargasTelefonicas with id " + id + " no longer exists.", enfe);
            }
            em.remove(TRecargasTelefonicas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TRecargasTelefonicas> findTRecargasTelefonicasEntities() {
        return findTRecargasTelefonicasEntities(true, -1, -1);
    }

    public List<TRecargasTelefonicas> findTRecargasTelefonicasEntities(int maxResults, int firstResult) {
        return findTRecargasTelefonicasEntities(false, maxResults, firstResult);
    }

    private List<TRecargasTelefonicas> findTRecargasTelefonicasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TRecargasTelefonicas.class));
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

    public TRecargasTelefonicas findTRecargasTelefonicas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TRecargasTelefonicas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTRecargasTelefonicasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TRecargasTelefonicas> rt = cq.from(TRecargasTelefonicas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
