package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.UserLoanDetailsDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_loan_details")
@Data
public class UserLoanDetails extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public UserLoanDetailsDTO userLoanDetailsToDTO(){
        UserLoanDetailsDTO loan = new UserLoanDetailsDTO();
        BeanUtils.copyProperties(this,loan);
        return loan;
    }
}
