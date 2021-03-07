/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jqmicrosistemas.abacus.controllers;

import java.awt.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jqmicrosistemas.abacus.controllers.exceptions.NonexistentEntityException;
import jqmicrosistemas.abacus.model.TClientes;
import org.hibernate.boot.registry.classloading.internal.TcclLookupPrecedence;
import org.springframework.stereotype.Component;

@Component
public class TClientesJpaController implements Serializable {

    public TClientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public void create(TClientes TClientes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TClientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TClientes TClientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TClientes = em.merge(TClientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TClientes.getFIdrecord();
                if (findTClientes(id) == null) {
                    throw new NonexistentEntityException("The tClientes with id " + id + " no longer exists.");
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
            TClientes TClientes;
            try {
                TClientes = em.getReference(TClientes.class, id);
                TClientes.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TClientes with id " + id + " no longer exists.", enfe);
            }
            em.remove(TClientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TClientes> findTClientesEntities() {
        return findTClientesEntities(true, -1, -1);
    }

    public List<TClientes> findTClientesEntities(int maxResults, int firstResult) {
        return findTClientesEntities(false, maxResults, firstResult);
    }

    private List<TClientes> findTClientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TClientes.class));
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

    public TClientes findTClientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TClientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getTClientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TClientes> rt = cq.from(TClientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }



//    Named Querys
//    Named Querys
    public List<TClientes> findByEmpresa(String empresa){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("TClientes.findByFEmpresa");

        q.setParameter(1, empresa);

        //el result es list pero no TIPO clientes
        try {
            //el result es list pero no TIPO clientes
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<TClientes> findByNombreAndEmpresa(String Nombre, String Empresa){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("TClientes.findByFNombreAndFIdEmpresa");

        q.setParameter(1, Nombre);
        q.setParameter(2, Empresa);

        try {
            //el result es list pero no TIPO clientes
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}

