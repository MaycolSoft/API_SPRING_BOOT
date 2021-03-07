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
import jqmicrosistemas.abacus.model.TPagosTarjeta;

/**
 *
 * @author Maycol
 */
public class TPagosTarjetaJpaController implements Serializable {

    public TPagosTarjetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TPagosTarjeta TPagosTarjeta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TPagosTarjeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TPagosTarjeta TPagosTarjeta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPagosTarjeta = em.merge(TPagosTarjeta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TPagosTarjeta.getFIdrecord();
                if (findTPagosTarjeta(id) == null) {
                    throw new NonexistentEntityException("The tPagosTarjeta with id " + id + " no longer exists.");
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
            TPagosTarjeta TPagosTarjeta;
            try {
                TPagosTarjeta = em.getReference(TPagosTarjeta.class, id);
                TPagosTarjeta.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TPagosTarjeta with id " + id + " no longer exists.", enfe);
            }
            em.remove(TPagosTarjeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TPagosTarjeta> findTPagosTarjetaEntities() {
        return findTPagosTarjetaEntities(true, -1, -1);
    }

    public List<TPagosTarjeta> findTPagosTarjetaEntities(int maxResults, int firstResult) {
        return findTPagosTarjetaEntities(false, maxResults, firstResult);
    }

    private List<TPagosTarjeta> findTPagosTarjetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TPagosTarjeta.class));
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

    public TPagosTarjeta findTPagosTarjeta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TPagosTarjeta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTPagosTarjetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TPagosTarjeta> rt = cq.from(TPagosTarjeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
