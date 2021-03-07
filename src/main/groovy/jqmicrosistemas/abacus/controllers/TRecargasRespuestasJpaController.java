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
import jqmicrosistemas.abacus.model.TRecargasRespuestas;

/**
 *
 * @author Maycol
 */
public class TRecargasRespuestasJpaController implements Serializable {

    public TRecargasRespuestasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TRecargasRespuestas TRecargasRespuestas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TRecargasRespuestas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TRecargasRespuestas TRecargasRespuestas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TRecargasRespuestas = em.merge(TRecargasRespuestas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TRecargasRespuestas.getFIdrecord();
                if (findTRecargasRespuestas(id) == null) {
                    throw new NonexistentEntityException("The tRecargasRespuestas with id " + id + " no longer exists.");
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
            TRecargasRespuestas TRecargasRespuestas;
            try {
                TRecargasRespuestas = em.getReference(TRecargasRespuestas.class, id);
                TRecargasRespuestas.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TRecargasRespuestas with id " + id + " no longer exists.", enfe);
            }
            em.remove(TRecargasRespuestas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TRecargasRespuestas> findTRecargasRespuestasEntities() {
        return findTRecargasRespuestasEntities(true, -1, -1);
    }

    public List<TRecargasRespuestas> findTRecargasRespuestasEntities(int maxResults, int firstResult) {
        return findTRecargasRespuestasEntities(false, maxResults, firstResult);
    }

    private List<TRecargasRespuestas> findTRecargasRespuestasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TRecargasRespuestas.class));
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

    public TRecargasRespuestas findTRecargasRespuestas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TRecargasRespuestas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTRecargasRespuestasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TRecargasRespuestas> rt = cq.from(TRecargasRespuestas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
