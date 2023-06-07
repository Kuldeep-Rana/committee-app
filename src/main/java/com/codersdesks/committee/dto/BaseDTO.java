package com.codersdesks.committee.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseDTO {
    private Timestamp created_on;
    private Long created_by;
    private Timestamp updated_on;
    private Long updated_by;
    private Boolean is_active;
}
