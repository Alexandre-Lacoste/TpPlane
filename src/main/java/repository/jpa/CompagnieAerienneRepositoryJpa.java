package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import DAO.Application;
import model.CompagnieAerienne;
import repository.ICompagnieAerienneRepository;

public class CompagnieAerienneRepositoryJpa implements ICompagnieAerienneRepository {


	@Override
	public CompagnieAerienne findById(String id) {
		CompagnieAerienne CompagnieAerienne = new CompagnieAerienne();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
//			TypedQuery<CompagnieAerienne> query = em.createQuery("select v from CompagnieAerienne v where v.id=:id", CompagnieAerienne.class);
//			query.setParameter("id", id);
//			CompagnieAerienne=query.getSingleResult();
			CompagnieAerienne= em.find(CompagnieAerienne.class, id);
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
		return CompagnieAerienne;
	}

	@Override
	public CompagnieAerienne save(CompagnieAerienne obj) {
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
	public void delete(CompagnieAerienne obj) {
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
	public List<CompagnieAerienne> findAll() {
		List<CompagnieAerienne> CompagnieAeriennes=new ArrayList<CompagnieAerienne>();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<CompagnieAerienne> query = em.createQuery("from CompagnieAerienne", CompagnieAerienne.class);
			CompagnieAeriennes=query.getResultList();
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
		return CompagnieAeriennes;
	}

}
