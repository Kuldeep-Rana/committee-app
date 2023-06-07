package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.Right;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class RightDTO extends BaseDTO {
    private Long rightId;
    private String name;
    private String right_group;

    public Right dtoToRight(){
        Right right = new Right();
        BeanUtils.copyProperties(this,right);
        return right;
    }
}
