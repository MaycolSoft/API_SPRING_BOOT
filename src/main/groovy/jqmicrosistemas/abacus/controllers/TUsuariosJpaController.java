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
import jqmicrosistemas.abacus.model.TClientes;
import jqmicrosistemas.abacus.model.TUsuarios;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maycol
 */
@Component
public class TUsuariosJpaController implements Serializable {

    public TUsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }





    public String create(TUsuarios TUsuarios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TUsuarios);
            em.getTransaction().commit();
        }catch (Exception ex){
            System.err.println("Error Creando Usuario Se Imprimira 2 mensajes -->");
            System.err.println(ex.getMessage());
            System.err.println(ex.getMessage());
            return ex.getMessage();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }

        return "Creado Exitosamente";
    }

    public String edit(TUsuarios TUsuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        String msg;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TUsuarios = em.merge(TUsuarios);
            em.getTransaction().commit();
        } catch (Exception ex) {
             msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TUsuarios.getFIdrecord();
                return "The tUsuarios with id " + id + " no longer exists.";
//                if (findTUsuarios(id) == null) {
//                    throw new NonexistentEntityException("The tUsuarios with id " + id + " no longer exists.");
//                }
            }
//            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return "Actualizado Exitosamente";
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TUsuarios TUsuarios;
            try {
                TUsuarios = em.getReference(TUsuarios.class, id);
                TUsuarios.getFIdrecord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TUsuarios with id " + id + " no longer exists.", enfe);
            }
            em.remove(TUsuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TUsuarios> findTUsuariosEntities() {
        return findTUsuariosEntities(true, -1, -1);
    }

    public List<TUsuarios> findTUsuariosEntities(int maxResults, int firstResult) {
        return findTUsuariosEntities(false, maxResults, firstResult);
    }

    private List<TUsuarios> findTUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TUsuarios.class));
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

    public TUsuarios findTUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TUsuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getTUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TUsuarios> rt = cq.from(TUsuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }


    //Named Query
    //Named Query
    public List<TUsuarios> findByFEmpresa(Integer Empresa){

        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("TUsuarios.findByFIdempresa");

        q.setParameter(1, Empresa);

        try {
            //el result es list pero no TIPO clientes

            return q.getResultList();
        } finally {
            em.close();
        }



    }

    public List<TUsuarios>  findByFIdrecord(Integer FIdrecord){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("TUsuarios.findByFIdrecord");

        q.setParameter(1, FIdrecord);

        try {
            //el result es list pero no TIPO clientes
            return q.getResultList();
        } finally {
            em.close();
        }

    }
}
