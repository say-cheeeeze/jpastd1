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
			
			ItemInfo itemCharger = new ItemInfo();
			itemCharger.setName( "휴대용충전기" );
			itemCharger.setPrice( 50000 );
			itemCharger.setStockQuantity( 10 );
			em.persist( itemCharger );
			
			ItemInfo itemFan = new ItemInfo();
			itemFan.setName( "선풍기" );
			itemFan.setPrice( 35700 );
			itemFan.setStockQuantity( 10 );
			em.persist( itemFan );
			
			OrderItemInfo orderItem1 = new OrderItemInfo();
			orderItem1.setCount( 1 );
			orderItem1.setItem( itemCharger );
			em.persist( orderItem1 );
			
			OrderItemInfo orderItem2 = new OrderItemInfo();
			orderItem2.setCount( 1 );
			orderItem2.setItem( itemCharger );
			em.persist( orderItem2 );
			
			MemberInfo member = new MemberInfo();
			member.setName( "yoonjae" );
			member.setStreet( "양천구" );
			member.setZipCode( "07938" );
			em.persist( member );
			
			OrderInfo order = new OrderInfo();
			order.setMemberInfo( member );
			order.getOrderItemList().add( orderItem1 );
			order.getOrderItemList().add( orderItem2 );
			order.setOrderDate( LocalDateTime.now() );
			order.setStatus( OrderStatus.ORDER );
			em.persist( order );
			
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
