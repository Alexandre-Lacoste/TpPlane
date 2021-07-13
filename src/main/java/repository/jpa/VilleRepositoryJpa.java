package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import DAO.Application;
import model.Ville;
import repository.IVilleRepository;

public class VilleRepositoryJpa implements IVilleRepository {


	@Override
	public Ville findById(Long id) {
		Ville Ville = new Ville();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
//			TypedQuery<Ville> query = em.createQuery("select v from Ville v where v.id=:id", Ville.class);
//			query.setParameter("id", id);
//			Ville=query.getSingleResult();
			Ville= em.find(Ville.class, id);
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
		return Ville;
	}

	@Override
	public Ville save(Ville obj) {
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
	public void delete(Ville obj) {
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
	public List<Ville> findAll() {
		List<Ville> Villes=new ArrayList<Ville>();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Ville> query = em.createQuery("from Ville", Ville.class);
			Villes=query.getResultList();
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
		return Villes;
	}

}
