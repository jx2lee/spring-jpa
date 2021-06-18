package com.jx2lee.springjpa;

import com.jx2lee.springjpa.domain.Address;
import com.jx2lee.springjpa.domain.Delivery;
import com.jx2lee.springjpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spring-jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("jx2lee");
            em.persist(member);


            // JPQL
            List<Member> resultJPQL = em.createQuery(
                    "select m from Member m where m.name like '%kim'", Member.class
            ).getResultList();

            // Criteria
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("name"), "kim"));
            List<Member> resultListCriteria = em.createQuery(cq).getResultList();

            // Native SQL
            List<Member> resultListNative = em.createNativeQuery("select MEMBER_ID, city, street, zipcode, name from MEMBER", Member.class)
                    .getResultList();

            for (Member findMember : resultListNative ) {
                System.out.println("findMember-name = " + findMember.getName());
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }


}
