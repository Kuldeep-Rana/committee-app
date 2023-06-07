package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.UserLoanDetails;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class UserLoanDetailsDTO extends BaseDTO{
    private Long user_loan_id;
    private Long user_id;
    private Long user_account_id;
    private Long committee_id;
    private Double loan_amount;
    private Double balance_loan;
    private Date start_date;
    private Date end_date;
    private Long loan_approved_by;
    private String loan_guarantor_ids;
    private Boolean is_approved;
    private Timestamp approved_on;

    public UserLoanDetails dtoToUserLoanDetails(){
        UserLoanDetails loan = new UserLoanDetails();
        BeanUtils.copyProperties(this,loan);
        return loan;
    }
}
