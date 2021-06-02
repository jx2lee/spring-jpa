package com.jx2lee.springjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spring-jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 준영속상태
            // JPA 에서 더이상 관리하지 않겠다는 의미 (detach)
            // 주로 사용하지 않지만 확인용으로 사용할 수 있으니 사용 방법은 익혀두도록 하자.
            Member member = em.find(Member.class, 25L);
//            member.setName("aaaaaaa");

            em.detach(member);

            // flush
            // em.flush 을 수행하면 쓰기 지연 SQL 저장소의 변경 쿼리가 DB 로 전달하여 수행한다.
            // DB 에 쓰기(수정, 삭제) 작업이 진행된다.
            // 영속성 컨텍스트를 비우지 않고 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화
//            Member member = new Member(25L, "test");
//            em.persist(member);
//
//            em.flush();
//            System.out.println("============================");
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
            // commit 이후 쓰기 지연 SQL 저장소에 담겨져 있는 SQL 들이 모두 실행된다.
            // 모두 == 이후에 발생하는 것을 확인할 수 있다.
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("============================");

            // Member 객체는 비영속 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("jx2lee");
//
            // 영속 상태
//            System.out.println("==== BEFORE ====");
//            em.persist(member);
//            System.out.println("==== AFTER ====");
//
//            Member findMember1 = em.find(Member.class, 101L);
//            // findMember2 조회 시 이미 캐시에 저장하고 있어 select query 가 중복으로 발생하지 않는다.
//            Member findMember2 = em.find(Member.class, 101L);
//
//            // 영속 엔티티의 동일성 보장 (101 번을 조회환 두 객체는 같다. true 반환)
//            System.out.println("result: " + (findMember1 == findMember2));
//
//            System.out.println("findMember.id: " + findMember1.getId());
//            System.out.println("findMember.name: " + findMember1.getName());

            // 변경 감지
//            Member member = em.find(Member.class, 150L);
//            member.setName("kkk");
            // em.persist 을 수행하지 않아도 된다.
            // 이유는 이미 db 에서 조회한 값을 영속성 컨텍스트에 저장해놓기 때문에
            // 굳이 다시 persist 하지 않아도 된다.


            // Member 객체는 비영속 상태
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("jx2lee");
//

            // 영속 상태
//            System.out.println("==== BEFORE ====");
//            em.persist(member);
//            System.out.println("==== AFTER ====");

            // 수정
//            em.persist 는 사용하지 않아도 됨
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("jx2lee2");
//            tx.commit();

            // 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
