package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.Role;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class RoleDTO extends BaseDTO{
    private Long roleId;
    private String role_name;

    public Role dtoToRole(){
        Role role = new Role();
        BeanUtils.copyProperties(this,role);
        return role;
    }
}
