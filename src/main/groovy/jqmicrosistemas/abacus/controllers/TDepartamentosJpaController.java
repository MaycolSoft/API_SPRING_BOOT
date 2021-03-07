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
import jqmicrosistemas.abacus.model.TDepartamentos;

/**
 *
 * @author Maycol
 */
public class TDepartamentosJpaController implements Serializable {

    public TDepartamentosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TDepartamentos TDepartamentos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TDepartamentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TDepartamentos TDepartamentos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TDepartamentos = em.merge(TDepartamentos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TDepartamentos.getFIdrecord();
                if (findTDepartamentos(id) == null) {
                    throw new NonexistentEntityException("The tDepartamentos with id " + id + " no longer exists.");
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
            TDepartamentos TDepartamentos;
            try {
                TDepartamentos = em.getReference(TDepartamentos.class, id);
                TDepartamentos.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TDepartamentos with id " + id + " no longer exists.", enfe);
            }
            em.remove(TDepartamentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TDepartamentos> findTDepartamentosEntities() {
        return findTDepartamentosEntities(true, -1, -1);
    }

    public List<TDepartamentos> findTDepartamentosEntities(int maxResults, int firstResult) {
        return findTDepartamentosEntities(false, maxResults, firstResult);
    }

    private List<TDepartamentos> findTDepartamentosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TDepartamentos.class));
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

    public TDepartamentos findTDepartamentos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TDepartamentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTDepartamentosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TDepartamentos> rt = cq.from(TDepartamentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
