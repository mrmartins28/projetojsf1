package br.com.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {
		
		try {
			
			if(factory == null) {
				
				factory = Persistence.createEntityManagerFactory("projetomavenjsf");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EntityManager getEntityManager() {// prover a persistência
		
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) {// retorna a primary key
		
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
