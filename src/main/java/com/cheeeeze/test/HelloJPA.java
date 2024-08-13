package com.cheeeeze.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cheeeeze.test.vo.MemberLegacy;

public class HelloJPA {
	
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
			
			// Member 등록
			saveMemberOne( em );
//			 saveMembers( em );
			
			// Member 목록
			// List<Member> memberList = getMemberList( em );
			
			// Member 페이징
			// List<Member> memberPageList = getMemberPageList( em );
			
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
	
	private static void saveMemberOne( EntityManager em ) {
		MemberLegacy memberLegacy = new MemberLegacy();
		memberLegacy.setName( "ADMINYJ" );
//		member.setRoleType( RoleType.ADMIN );
		System.out.println( "################" );
		em.persist( memberLegacy ); // 이 다음에 commit한다
		System.out.println( "member.getId() = " + memberLegacy.getId() );
		System.out.println( "################" );
	}
	
	private static void saveMembers( EntityManager em ) {
		for ( long i = 0; i < 10; i++ ) {
			MemberLegacy m = new MemberLegacy();
			m.setName( i + "name" );
			em.persist( m );
		}
	}
	
	private static List<MemberLegacy> getMemberPageList( EntityManager em ) {
		
		List<MemberLegacy> resultList = em.createQuery( "select m from MemberLegacy as m", MemberLegacy.class )
										  .setFirstResult( 5 )
										  .setMaxResults( 10 )
										  .getResultList();
		
		for ( MemberLegacy memberLegacy : resultList ) {
			System.out.println( "member.getName() = " + memberLegacy.getName() );
		}
		return resultList;
	}
	
	private static List<MemberLegacy> getMemberList( EntityManager em ) {
		
		// JPQL
		List<MemberLegacy> resultList = em.createQuery( "select m from MemberLegacy as m", MemberLegacy.class ).getResultList();
		for ( MemberLegacy memberLegacy : resultList ) {
			System.out.println( "member.getName() = " + memberLegacy.getName() );
		}
		return resultList;
	}
	
}
