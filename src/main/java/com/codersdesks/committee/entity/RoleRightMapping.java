package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.RoleRightMappingDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role_right_mapping")
@NoArgsConstructor
public class RoleRightMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_right_mapping_id;
    private Long role_id;
    private Long right_id;

    public RoleRightMappingDTO roleRightMappingToDTO(){
        RoleRightMappingDTO mappingDTO  = new RoleRightMappingDTO();
        BeanUtils.copyProperties(this,mappingDTO);
        return mappingDTO;
    }
}
