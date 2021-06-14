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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
