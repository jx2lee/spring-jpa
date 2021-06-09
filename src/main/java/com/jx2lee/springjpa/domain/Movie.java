package com.jx2lee.springjpa.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {

    private String director;
    private String actor;

}
