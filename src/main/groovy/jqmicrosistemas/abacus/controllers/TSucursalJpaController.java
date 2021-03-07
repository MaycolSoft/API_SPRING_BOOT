/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jqmicrosistemas.abacus.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jqmicrosistemas.abacus.controllers.exceptions.NonexistentEntityException;
import jqmicrosistemas.abacus.model.TSucursal;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maycol
 */
@Component
public class TSucursalJpaController implements Serializable {

    public TSucursalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TSucursal TSucursal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TSucursal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TSucursal TSucursal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TSucursal = em.merge(TSucursal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TSucursal.getFIdrecord();
                if (findTSucursal(id) == null) {
                    throw new NonexistentEntityException("The tSucursal with id " + id + " no longer exists.");
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
            TSucursal TSucursal;
            try {
                TSucursal = em.getReference(TSucursal.class, id);
                TSucursal.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TSucursal with id " + id + " no longer exists.", enfe);
            }
            em.remove(TSucursal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TSucursal> findTSucursalEntities() {
        return findTSucursalEntities(true, -1, -1);
    }

    public List<TSucursal> findTSucursalEntities(int maxResults, int firstResult) {
        return findTSucursalEntities(false, maxResults, firstResult);
    }

    private List<TSucursal> findTSucursalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TSucursal.class));
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

    public TSucursal findTSucursal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TSucursal.class, id);
        } finally {
            em.close();
        }
    }

    public int getTSucursalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TSucursal> rt = cq.from(TSucursal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }



    //Named Querys
    public List<TSucursal> findByFIdempresaNombreAndIdSucursal(Integer Empresa){

        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("TSucursal.findByFIdempresaNombreAndIdSucursal");

        q.setParameter(1, Empresa);
        try {
            //el result es list pero no TIPO clientes
            TSucursal tSucursal = new TSucursal();
            List<TSucursal> records = q.getResultList();
            List<TSucursal> resultList = new ArrayList<>();


//            for(TSucursal sucursal: records){
//
//                tSucursal.setFNombresucursal(sucursal.getFNombresucursal());
//               tSucursal.setFIdsucursal(sucursal.getFIdsucursal());
//
//               resultList.add(tSucursal);
//            }
            return records;

//            return q.getResultList();
        } finally {
            em.close();
        }

    }
    
}
