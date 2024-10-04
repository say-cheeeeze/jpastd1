package com.cheeeeze.shop;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cheeeeze.shop.domain.*;

public class ShopMain {
	
	public static void main( String[] args ) {
		
		String persistenceUnitName = "hello";// persistence.xml 에 있다.
		
		// 1. entityManagerFactory 를 생성한다. application 에서 단 하나만 생성해야한다.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( persistenceUnitName );
		
		// 2. EntityManagerFactory 로부터 entityManager 를 생성
		EntityManager em = emf.createEntityManager();
		
		// 3. EntityManager 로부터 Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		/* transaction 시작 */
		tx.begin(); // db transaction 시작 선언
		
		try {
			
			BookInfo book1 = new BookInfo();
			book1.setTitle( "book1" );
			em.persist( book1 );
			
			System.out.println( "book1.getId() = " + book1.getId() );
			
			tx.commit();
		}
		catch ( Exception e ) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			System.out.println( "entity manager close" );
			
			// 팩토리 종료
			emf.close();
			System.out.println( "entity manager factory close()" );
		}
	}
}
