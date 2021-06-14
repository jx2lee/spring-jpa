package com.jx2lee.springjpa.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Embedded
    private Address address;

    private DeliveryStatus deliveryStatus;

    // Order 와 양방향 설정시
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

}
