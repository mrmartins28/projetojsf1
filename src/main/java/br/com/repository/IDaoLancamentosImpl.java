package br.com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entidades.Lancamento;
import br.com.jpautil.JPAUtil;

public class IDaoLancamentosImpl implements IDaoLancamento {

	@Override
	public List<Lancamento> consultar(Long codUser) {
		
		List<Lancamento> list = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		list = (List<Lancamento>) entityManager.createQuery(" from Lancamento where usuario.id =" + codUser).getResultList();
		
		transaction.commit();
		entityManager.close();
	
		return list;
	}

}
