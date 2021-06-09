package com.jx2lee.springjpa.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    private DeliveryStatus deliveryStatus;

    // Order 와 양방향 설정시
    @OneToOne(mappedBy = "delivery")
    private Order order;

}
