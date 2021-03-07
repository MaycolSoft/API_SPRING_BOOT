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
import jqmicrosistemas.abacus.model.TPermisosGrupo;

/**
 *
 * @author Maycol
 */
public class TPermisosGrupoJpaController implements Serializable {

    public TPermisosGrupoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TPermisosGrupo TPermisosGrupo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TPermisosGrupo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TPermisosGrupo TPermisosGrupo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPermisosGrupo = em.merge(TPermisosGrupo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TPermisosGrupo.getFIdrecord();
                if (findTPermisosGrupo(id) == null) {
                    throw new NonexistentEntityException("The tPermisosGrupo with id " + id + " no longer exists.");
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
            TPermisosGrupo TPermisosGrupo;
            try {
                TPermisosGrupo = em.getReference(TPermisosGrupo.class, id);
                TPermisosGrupo.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TPermisosGrupo with id " + id + " no longer exists.", enfe);
            }
            em.remove(TPermisosGrupo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TPermisosGrupo> findTPermisosGrupoEntities() {
        return findTPermisosGrupoEntities(true, -1, -1);
    }

    public List<TPermisosGrupo> findTPermisosGrupoEntities(int maxResults, int firstResult) {
        return findTPermisosGrupoEntities(false, maxResults, firstResult);
    }

    private List<TPermisosGrupo> findTPermisosGrupoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TPermisosGrupo.class));
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

    public TPermisosGrupo findTPermisosGrupo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TPermisosGrupo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTPermisosGrupoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TPermisosGrupo> rt = cq.from(TPermisosGrupo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
