package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.UserAccountDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_account")
@Data
public class UserAccount extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_account_id;
    private Long user_id;
    private Long committee_id;
    private Double monthly_share;
    private Double total_share;
    private Timestamp joined_on;
    private Long loan_id;
    private Double penalty_amount;
    private Timestamp closed_on;

    public UserAccountDTO useAccountToDTO(){
        UserAccountDTO act  = new UserAccountDTO();
        BeanUtils.copyProperties(this,act);
        return act;
    }
}
