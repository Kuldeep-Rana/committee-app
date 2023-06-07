package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.RightDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rights")
@Data
@NoArgsConstructor
public class Right extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rightId;
    private String name;
    private String right_group;

    public RightDTO rightToDto(){
        RightDTO rightDTO = new RightDTO();
        BeanUtils.copyProperties(this,rightDTO);
        return rightDTO;
    }
}
