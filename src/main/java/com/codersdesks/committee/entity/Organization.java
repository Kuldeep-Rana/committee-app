package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.OrganizationDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "organization",uniqueConstraints = { @UniqueConstraint(columnNames = {"unique_identifier"}) })
@Data
public class Organization extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orgId;
    private String name;
    private String unique_identifier;
    private String login_url;
    private String logo_url;

    public OrganizationDTO organizationToDTO(){
        OrganizationDTO dto = new OrganizationDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
