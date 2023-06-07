package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.CommitteeDetailsDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "committee_details",uniqueConstraints = { @UniqueConstraint(columnNames = {"committee_name"}) })
@Data
public class CommitteeDetails extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long committee_id;
    private String committee_name;
    private long org_id;
    private Double monthly_share;
    private Double loan_interest_rate;
    private Double loan_limit;

    public CommitteeDetailsDTO committeeDetailsToDTO(){
        CommitteeDetailsDTO dto = new CommitteeDetailsDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}