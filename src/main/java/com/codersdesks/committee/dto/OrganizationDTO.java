package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.Organization;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@NoArgsConstructor
public class OrganizationDTO extends BaseDTO implements Serializable {
    private Long orgId;
    private String name;
    private String unique_identifier;
    private Timestamp created_on;
    private Long created_by;
    private Boolean is_active;
    private String login_url;
    private String logo_url;

    public Organization dtoToOrganization(){
        Organization organization = new Organization();
        BeanUtils.copyProperties(this,organization);
        if(organization.getCreated_on() == null){
            organization.setCreated_on(Timestamp.from(Instant.now()));
        }
        return organization;
    }
}
