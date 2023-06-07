package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.RoleRightMapping;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class RoleRightMappingDTO {
    private Long role_right_mapping_id;
    private Long role_id;
    private Long right_id;

    public RoleRightMapping dtoToRoleRightMapping(){
        RoleRightMapping mapping = new RoleRightMapping();
        BeanUtils.copyProperties(this,mapping);
        return mapping;
    }
}
