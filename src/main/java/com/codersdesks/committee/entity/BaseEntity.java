package com.codersdesks.committee.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Column(nullable = false)
    private Timestamp created_on = Timestamp.from(Instant.now());
    @Column(nullable = false)
    private Long created_by;
    private Timestamp updated_on;
    private Long updated_by;
    @Column(nullable = false)
    private Boolean is_active;
}
