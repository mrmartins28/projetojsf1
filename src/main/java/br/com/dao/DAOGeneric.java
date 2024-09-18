package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JPAUtil;

public class DAOGeneric<E> {
	
	
	
	public void salvar(E entidade) {
		
		EntityManager entityManager= JPAUtil.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(entidade); // método persist salva o objeto
		
		transaction.commit();
		entityManager.close();
		
	}

}
