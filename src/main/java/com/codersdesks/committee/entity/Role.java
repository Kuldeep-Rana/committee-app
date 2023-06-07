package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.RoleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String role_name;

    public RoleDTO roleToDto(){
        RoleDTO dto = new RoleDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}

