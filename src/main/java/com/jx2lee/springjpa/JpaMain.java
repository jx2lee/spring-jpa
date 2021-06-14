package com.jx2lee.springjpa;

import com.jx2lee.springjpa.domain.Address;
import com.jx2lee.springjpa.domain.Delivery;
import com.jx2lee.springjpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.print.attribute.standard.Media;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spring-jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Address address = new Address("city", "street", "10000");
            Delivery delivery = new Delivery();
            delivery.setAddress(address);
            em.persist(delivery);

            Delivery delivery2 = new Delivery();
            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());
            delivery2.setAddress(newAddress);
            em.persist(delivery2);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }


}
