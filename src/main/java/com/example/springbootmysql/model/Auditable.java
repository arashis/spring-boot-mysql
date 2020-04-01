package com.example.springbootmysql.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @CreatedBy
    @Column(name = "create_by", nullable = false, updatable = false)
    protected U createdBy;

    @CreatedDate
    @Column(name = "create_date", nullable = false, updatable = false)
    protected Date creationDate;

    @LastModifiedBy
    @Column(name = "update_by")
    protected U updateBy;

    @LastModifiedDate
    @Column(name = "update_date")
    protected Date updateDate;

}
