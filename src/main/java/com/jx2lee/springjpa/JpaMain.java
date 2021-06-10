package com.jx2lee.springjpa;

import com.jx2lee.springjpa.domain.Order;
import org.hibernate.Hibernate;
import org.hibernate.jpa.internal.PersistenceUnitUtilImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spring-jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Order order = new Order();
            order.setOrderDate(LocalDateTime.now());

            em.persist(order);
            em.flush();
            em.clear();

            // Order findOrder = em.find(Order.class, order.getId());
            Order refOrder = em.getReference(Order.class, order.getId());
            System.out.println("findOrder = " + refOrder.getClass());
            // 간접 초기화 // findOrder = class com.jx2lee.springjpa.domain.Order$HibernateProxy$IQdRxiAH
            // 직접 초기화, 단 JPA 표준은 강제초기화 없음 // Hibernate.initialize(refOrder);
            // System.out.println("refOrder.getOrderDate() = " + refOrder.getOrderDate());
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refOrder));

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }


}
