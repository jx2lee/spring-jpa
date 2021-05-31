package com.jx2lee.springjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spring-jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();ㄴ
        tx.begin();

        try {

            // Member 객체는 비영속 상태
            Member member = new Member();
            member.setId(1L);
            member.setName("jx2lee");

            // 영속 상태
            System.out.println("==== BEFORE ====");
            em.persist(member);
            System.out.println("==== AFTER ====");

            tx.commit();

//            수정
//            em.persist 는 사용하지 않아도 됨
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("jx2lee2");
//            tx.commit();

//            삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
//            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
