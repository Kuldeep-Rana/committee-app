package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.time.Instant;

@Data
public class UserDTO extends BaseDTO{
    private Long userId;
    private String user_name;
    private String mobile;
    private String email;
    private String password;
    private Long role_id;
    private Long org_id;
    private boolean	is_admin;
    private Boolean is_logged_in;
    private String logged_in_ip;

    public User dtoToUser(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        if(user.getCreated_on() == null){
            user.setCreated_on(Timestamp.from(Instant.now()));
        }
        if(user.getUpdated_on() == null){
            user.setUpdated_on(Timestamp.from(Instant.now()));
        }
        return user;
    }
}
