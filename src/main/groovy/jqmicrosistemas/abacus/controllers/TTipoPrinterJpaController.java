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
import jqmicrosistemas.abacus.model.TTipoPrinter;

/**
 *
 * @author Maycol
 */
public class TTipoPrinterJpaController implements Serializable {

    public TTipoPrinterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TTipoPrinter TTipoPrinter) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TTipoPrinter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TTipoPrinter TTipoPrinter) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TTipoPrinter = em.merge(TTipoPrinter);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TTipoPrinter.getFIdrecord();
                if (findTTipoPrinter(id) == null) {
                    throw new NonexistentEntityException("The tTipoPrinter with id " + id + " no longer exists.");
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
            TTipoPrinter TTipoPrinter;
            try {
                TTipoPrinter = em.getReference(TTipoPrinter.class, id);
                TTipoPrinter.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TTipoPrinter with id " + id + " no longer exists.", enfe);
            }
            em.remove(TTipoPrinter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TTipoPrinter> findTTipoPrinterEntities() {
        return findTTipoPrinterEntities(true, -1, -1);
    }

    public List<TTipoPrinter> findTTipoPrinterEntities(int maxResults, int firstResult) {
        return findTTipoPrinterEntities(false, maxResults, firstResult);
    }

    private List<TTipoPrinter> findTTipoPrinterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TTipoPrinter.class));
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

    public TTipoPrinter findTTipoPrinter(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TTipoPrinter.class, id);
        } finally {
            em.close();
        }
    }

    public int getTTipoPrinterCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TTipoPrinter> rt = cq.from(TTipoPrinter.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
