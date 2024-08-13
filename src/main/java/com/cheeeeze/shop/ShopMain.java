package com.cheeeeze.shop;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cheeeeze.shop.domain.Member;
import com.cheeeeze.shop.domain.Team;

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
			Team team = new Team();
			team.setName( "teamUSA" );
			em.persist( team );
			
			Member member = new Member();
			member.setName( "yoonjae" );
			member.setTeam( team );
			em.persist( member );
			
			em.flush();
			em.clear();
			
			Team team1 = em.find( Team.class, 1L );
			List<Member> members = team1.getMembers();
			for ( Member member1 : members ) {
				System.out.println( "member1.getName() = " + member1.getName() );
			}
			
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
