package com.codersdesks.committee.entity;

import com.codersdesks.committee.dto.UserLoanTransactionsDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_loan_transactions")
@Data
public class UserLoanTransactions extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_loan_trx_id;
    private Long user_loan_id;
    private Double loan_amount;
    private Double previous_balance_loan;
    private Double balance_loan;
    private Double principal_amount_paid;
    private Double interest_amount;
    private Double interest_paid;
    private Double interest_remaining;
    private Double penalty_amount;
    private Date paid_on;

    public UserLoanTransactionsDTO userLoanTransactionToDTO(){
        UserLoanTransactionsDTO transactions = new UserLoanTransactionsDTO();
        BeanUtils.copyProperties(this,transactions);
        return transactions;
    }
}
