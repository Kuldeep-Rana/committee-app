package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.UserAccount;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

@Data
public class UserAccountDTO extends BaseDTO{
    private Long user_account_id;
    private Long user_id;
    private Long committee_id;
    private Double monthly_share;
    private Double total_share;
    private Timestamp joined_on;
    private Long loan_id;
    private Double penalty_amount;
    private Timestamp closed_on;

    public UserAccount dtoToUserAccount(){
        UserAccount act  = new UserAccount();
        BeanUtils.copyProperties(this,act);
        return act;
    }
}
