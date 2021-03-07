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
import jqmicrosistemas.abacus.model.TDireccionEnvioClientes;

/**
 *
 * @author Maycol
 */
public class TDireccionEnvioClientesJpaController implements Serializable {

    public TDireccionEnvioClientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TDireccionEnvioClientes TDireccionEnvioClientes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TDireccionEnvioClientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TDireccionEnvioClientes TDireccionEnvioClientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TDireccionEnvioClientes = em.merge(TDireccionEnvioClientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TDireccionEnvioClientes.getFIdrecord();
                if (findTDireccionEnvioClientes(id) == null) {
                    throw new NonexistentEntityException("The tDireccionEnvioClientes with id " + id + " no longer exists.");
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
            TDireccionEnvioClientes TDireccionEnvioClientes;
            try {
                TDireccionEnvioClientes = em.getReference(TDireccionEnvioClientes.class, id);
                TDireccionEnvioClientes.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TDireccionEnvioClientes with id " + id + " no longer exists.", enfe);
            }
            em.remove(TDireccionEnvioClientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TDireccionEnvioClientes> findTDireccionEnvioClientesEntities() {
        return findTDireccionEnvioClientesEntities(true, -1, -1);
    }

    public List<TDireccionEnvioClientes> findTDireccionEnvioClientesEntities(int maxResults, int firstResult) {
        return findTDireccionEnvioClientesEntities(false, maxResults, firstResult);
    }

    private List<TDireccionEnvioClientes> findTDireccionEnvioClientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TDireccionEnvioClientes.class));
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

    public TDireccionEnvioClientes findTDireccionEnvioClientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TDireccionEnvioClientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getTDireccionEnvioClientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TDireccionEnvioClientes> rt = cq.from(TDireccionEnvioClientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
