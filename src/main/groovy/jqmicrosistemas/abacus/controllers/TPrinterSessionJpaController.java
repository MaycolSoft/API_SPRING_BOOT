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
import jqmicrosistemas.abacus.model.TPrinterSession;

/**
 *
 * @author Maycol
 */
public class TPrinterSessionJpaController implements Serializable {

    public TPrinterSessionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TPrinterSession TPrinterSession) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TPrinterSession);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TPrinterSession TPrinterSession) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPrinterSession = em.merge(TPrinterSession);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TPrinterSession.getFIdrecord();
                if (findTPrinterSession(id) == null) {
                    throw new NonexistentEntityException("The tPrinterSession with id " + id + " no longer exists.");
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
            TPrinterSession TPrinterSession;
            try {
                TPrinterSession = em.getReference(TPrinterSession.class, id);
                TPrinterSession.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TPrinterSession with id " + id + " no longer exists.", enfe);
            }
            em.remove(TPrinterSession);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TPrinterSession> findTPrinterSessionEntities() {
        return findTPrinterSessionEntities(true, -1, -1);
    }

    public List<TPrinterSession> findTPrinterSessionEntities(int maxResults, int firstResult) {
        return findTPrinterSessionEntities(false, maxResults, firstResult);
    }

    private List<TPrinterSession> findTPrinterSessionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TPrinterSession.class));
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

    public TPrinterSession findTPrinterSession(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TPrinterSession.class, id);
        } finally {
            em.close();
        }
    }

    public int getTPrinterSessionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TPrinterSession> rt = cq.from(TPrinterSession.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
