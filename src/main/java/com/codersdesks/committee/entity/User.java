package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users",uniqueConstraints = { @UniqueConstraint(columnNames = {"email","mobile"}) })
@Data
public class User extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public UserDTO userToDto(){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(this,userDTO);
        userDTO.setPassword(null);
        return userDTO;
    }
}
