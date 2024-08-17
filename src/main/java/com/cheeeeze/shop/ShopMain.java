package com.cheeeeze.shop;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cheeeeze.shop.domain.*;

public class ShopMain {
	
	public static void main( String[] args ) {
		String persistenceUnitName = "hello";// persistence.xml 에 있다.
		
		// 1. entityManagerFactory 를 생성한다.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( persistenceUnitName );
		
		// 2. EntityManagerFactory 로부터 entityManager 를 생성
		EntityManager em = emf.createEntityManager();
		
		// 3. EntityManager 로부터 Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		/* transaction 시작 */
		tx.begin(); // db transaction 시작 선언
		
		try {
			
			tx.commit();
		}
		catch ( Exception e ) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
		}
		// 팩토리 종료
		emf.close();
	}
}
