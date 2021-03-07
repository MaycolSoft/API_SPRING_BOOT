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
import jqmicrosistemas.abacus.model.TFacturasImpresionPendiente;

/**
 *
 * @author Maycol
 */
public class TFacturasImpresionPendienteJpaController implements Serializable {

    public TFacturasImpresionPendienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TFacturasImpresionPendiente TFacturasImpresionPendiente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TFacturasImpresionPendiente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TFacturasImpresionPendiente TFacturasImpresionPendiente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TFacturasImpresionPendiente = em.merge(TFacturasImpresionPendiente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TFacturasImpresionPendiente.getFIdrecord();
                if (findTFacturasImpresionPendiente(id) == null) {
                    throw new NonexistentEntityException("The tFacturasImpresionPendiente with id " + id + " no longer exists.");
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
            TFacturasImpresionPendiente TFacturasImpresionPendiente;
            try {
                TFacturasImpresionPendiente = em.getReference(TFacturasImpresionPendiente.class, id);
                TFacturasImpresionPendiente.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TFacturasImpresionPendiente with id " + id + " no longer exists.", enfe);
            }
            em.remove(TFacturasImpresionPendiente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TFacturasImpresionPendiente> findTFacturasImpresionPendienteEntities() {
        return findTFacturasImpresionPendienteEntities(true, -1, -1);
    }

    public List<TFacturasImpresionPendiente> findTFacturasImpresionPendienteEntities(int maxResults, int firstResult) {
        return findTFacturasImpresionPendienteEntities(false, maxResults, firstResult);
    }

    private List<TFacturasImpresionPendiente> findTFacturasImpresionPendienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TFacturasImpresionPendiente.class));
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

    public TFacturasImpresionPendiente findTFacturasImpresionPendiente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TFacturasImpresionPendiente.class, id);
        } finally {
            em.close();
        }
    }

    public int getTFacturasImpresionPendienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TFacturasImpresionPendiente> rt = cq.from(TFacturasImpresionPendiente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
