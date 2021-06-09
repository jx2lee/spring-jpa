package com.jx2lee.springjpa.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@MappedSuperclass
public abstract class BaseEntity {

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

}
