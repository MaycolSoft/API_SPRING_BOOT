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
import jqmicrosistemas.abacus.model.TTipoSuplidor;

/**
 *
 * @author Maycol
 */
public class TTipoSuplidorJpaController implements Serializable {

    public TTipoSuplidorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TTipoSuplidor TTipoSuplidor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TTipoSuplidor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TTipoSuplidor TTipoSuplidor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TTipoSuplidor = em.merge(TTipoSuplidor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TTipoSuplidor.getFIdrecord();
                if (findTTipoSuplidor(id) == null) {
                    throw new NonexistentEntityException("The tTipoSuplidor with id " + id + " no longer exists.");
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
            TTipoSuplidor TTipoSuplidor;
            try {
                TTipoSuplidor = em.getReference(TTipoSuplidor.class, id);
                TTipoSuplidor.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TTipoSuplidor with id " + id + " no longer exists.", enfe);
            }
            em.remove(TTipoSuplidor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TTipoSuplidor> findTTipoSuplidorEntities() {
        return findTTipoSuplidorEntities(true, -1, -1);
    }

    public List<TTipoSuplidor> findTTipoSuplidorEntities(int maxResults, int firstResult) {
        return findTTipoSuplidorEntities(false, maxResults, firstResult);
    }

    private List<TTipoSuplidor> findTTipoSuplidorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TTipoSuplidor.class));
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

    public TTipoSuplidor findTTipoSuplidor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TTipoSuplidor.class, id);
        } finally {
            em.close();
        }
    }

    public int getTTipoSuplidorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TTipoSuplidor> rt = cq.from(TTipoSuplidor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
