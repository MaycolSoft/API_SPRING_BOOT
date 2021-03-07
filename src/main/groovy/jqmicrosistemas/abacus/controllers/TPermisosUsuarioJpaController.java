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
import jqmicrosistemas.abacus.controllers.exceptions.PreexistingEntityException;
import jqmicrosistemas.abacus.model.TPermisosUsuario;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maycol
 */
@Component
public class TPermisosUsuarioJpaController implements Serializable {

    public TPermisosUsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TPermisosUsuario TPermisosUsuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TPermisosUsuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTPermisosUsuario(TPermisosUsuario.getFUsuario()) != null) {
                throw new PreexistingEntityException("TPermisosUsuario " + TPermisosUsuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TPermisosUsuario TPermisosUsuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPermisosUsuario = em.merge(TPermisosUsuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TPermisosUsuario.getFUsuario();
                if (findTPermisosUsuario(id) == null) {
                    throw new NonexistentEntityException("The tPermisosUsuario with id " + id + " no longer exists.");
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
            TPermisosUsuario TPermisosUsuario;
            try {
                TPermisosUsuario = em.getReference(TPermisosUsuario.class, id);
                TPermisosUsuario.getFUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TPermisosUsuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(TPermisosUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TPermisosUsuario> findTPermisosUsuarioEntities() {
        return findTPermisosUsuarioEntities(true, -1, -1);
    }

    public List<TPermisosUsuario> findTPermisosUsuarioEntities(int maxResults, int firstResult) {
        return findTPermisosUsuarioEntities(false, maxResults, firstResult);
    }

    private List<TPermisosUsuario> findTPermisosUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TPermisosUsuario.class));
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

    public TPermisosUsuario findTPermisosUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TPermisosUsuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getTPermisosUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TPermisosUsuario> rt = cq.from(TPermisosUsuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
