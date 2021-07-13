package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import DAO.Application;
import model.Aeroport;
import repository.IAeroportRepository;

public class AeroportRepositoryJpa implements IAeroportRepository {

	@Override
	public Aeroport findById(String id) {
		Aeroport Aeroport = new Aeroport();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
//			TypedQuery<Aeroport> query = em.createQuery("select v from Aeroport v where v.id=:id", Aeroport.class);
//			query.setParameter("id", id);
//			Aeroport=query.getSingleResult();
			Aeroport= em.find(Aeroport.class, id);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}			
		finally {
			if (em != null) {
				em.close();
			}
		}
		return Aeroport;
	}

	@Override
	public Aeroport save(Aeroport obj) {
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			obj=em.merge(obj);
			tx.commit();
			
		} catch (Exception e) {;
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}			
		finally {
			if (em != null) {
				em.close();
			}
		}
		return obj;
	}

	@Override
	public void delete(Aeroport obj) {
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}			
		finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

	@Override
	public List<Aeroport> findAll() {
		List<Aeroport> Aeroports=new ArrayList<Aeroport>();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Aeroport> query = em.createQuery("from Aeroport", Aeroport.class);
			Aeroports=query.getResultList();
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}			
		finally {
			if (em != null) {
				em.close();
			}
		}
		return Aeroports;
	}
}
