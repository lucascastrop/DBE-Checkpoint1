package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Plants;
import br.com.fiap.utils.JPAUtil;

public class PlantsDao {

	public void save(Plants setup) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		
		manager.close();
		
	}

	public List<Plants> getAll() {
		EntityManager manager = JPAUtil.getEntityManager();
		String jpql = "SELECT s FROM Setup s";
		TypedQuery<Plants> query = manager.createQuery(jpql, Plants.class);
		// TODO manager.close();

		return query.getResultList();
		
	}

}
