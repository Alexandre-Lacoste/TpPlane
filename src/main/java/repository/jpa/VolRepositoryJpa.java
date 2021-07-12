package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import DAO.Application;
import model.Vol;
import repository.IVolRepository;

public class VolRepositoryJpa implements IVolRepository {


	@Override
	public Vol findById(Long id) {
		Vol vol = new Vol();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
//			TypedQuery<Vol> query = em.createQuery("select v from vol v where v.id=:id", Vol.class);
//			query.setParameter("id", id);
//			vol=query.getSingleResult();
			vol= em.find(Vol.class, id);
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
		return vol;
	}

	@Override
	public Vol save(Vol obj) {
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
	public void delete(Vol obj) {
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
	public List<Vol> findAll() {
		List<Vol> vols=new ArrayList<Vol>();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Vol> query = em.createQuery("from vol", Vol.class);
			vols=query.getResultList();
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
		return vols;
	}

}
