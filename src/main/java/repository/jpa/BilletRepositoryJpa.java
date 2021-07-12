package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import application.Application;
import model.Billet;
import repository.IBilletRepository;

public class BilletRepositoryJpa implements IBilletRepository {

	@Override
	public List<Billet> findAll() {
		List<Billet> billets = new ArrayList<Billet>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Billet> query = em.createQuery("select e from Evaluation e ", Billet.class);

			billets = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return billets;
	}

	@Override
	public Billet findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Billet save(Billet obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Billet obj) {
		// TODO Auto-generated method stub
		
	}

}
