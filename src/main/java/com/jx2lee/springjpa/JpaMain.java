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
            Member member1 = new Member();
            member1.setName("A");
            Member member2 = new Member();
            member2.setName("A");
            Member member3 = new Member();
            member3.setName("A");

            System.out.println("-----------------");

            em.persist(member1); //1, 51
            em.persist(member2); //MEM
            em.persist(member3); //MEM

            System.out.println("member.getId = " + member1.getId());
            System.out.println("member.getId = " + member2.getId());
            System.out.println("member.getId = " + member3.getId());
            System.out.println("-----------------");

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
