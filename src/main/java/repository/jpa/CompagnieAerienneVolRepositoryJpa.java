package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import DAO.Application;
import model.CompagnieAerienneVol;
import repository.ICompagnieAerienneVolRepository;

public class CompagnieAerienneVolRepositoryJpa implements ICompagnieAerienneVolRepository{
	@Override
	public CompagnieAerienneVol findById(Long id) {
		CompagnieAerienneVol CompagnieAerienneVol = new CompagnieAerienneVol();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
//			TypedQuery<CompagnieAerienneVol> query = em.createQuery("select v from CompagnieAerienneVol v where v.id=:id", CompagnieAerienneVol.class);
//			query.setParameter("id", id);
//			CompagnieAerienneVol=query.getSingleResult();
			CompagnieAerienneVol= em.find(CompagnieAerienneVol.class, id);
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
		return CompagnieAerienneVol;
	}

	@Override
	public CompagnieAerienneVol save(CompagnieAerienneVol obj) {
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
	public void delete(CompagnieAerienneVol obj) {
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
	public List<CompagnieAerienneVol> findAll() {
		List<CompagnieAerienneVol> CompagnieAerienneVols=new ArrayList<CompagnieAerienneVol>();
		EntityManager em=null;
		EntityTransaction tx=null;
		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<CompagnieAerienneVol> query = em.createQuery("from CompagnieAerienneVol", CompagnieAerienneVol.class);
			CompagnieAerienneVols=query.getResultList();
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
		return CompagnieAerienneVols;
	}

}
