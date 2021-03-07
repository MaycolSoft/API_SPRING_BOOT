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
import jqmicrosistemas.abacus.model.TTipoTarjeta;

/**
 *
 * @author Maycol
 */
public class TTipoTarjetaJpaController implements Serializable {

    public TTipoTarjetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TTipoTarjeta TTipoTarjeta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TTipoTarjeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TTipoTarjeta TTipoTarjeta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TTipoTarjeta = em.merge(TTipoTarjeta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TTipoTarjeta.getFIdrecord();
                if (findTTipoTarjeta(id) == null) {
                    throw new NonexistentEntityException("The tTipoTarjeta with id " + id + " no longer exists.");
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
            TTipoTarjeta TTipoTarjeta;
            try {
                TTipoTarjeta = em.getReference(TTipoTarjeta.class, id);
                TTipoTarjeta.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TTipoTarjeta with id " + id + " no longer exists.", enfe);
            }
            em.remove(TTipoTarjeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TTipoTarjeta> findTTipoTarjetaEntities() {
        return findTTipoTarjetaEntities(true, -1, -1);
    }

    public List<TTipoTarjeta> findTTipoTarjetaEntities(int maxResults, int firstResult) {
        return findTTipoTarjetaEntities(false, maxResults, firstResult);
    }

    private List<TTipoTarjeta> findTTipoTarjetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TTipoTarjeta.class));
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

    public TTipoTarjeta findTTipoTarjeta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TTipoTarjeta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTTipoTarjetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TTipoTarjeta> rt = cq.from(TTipoTarjeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
