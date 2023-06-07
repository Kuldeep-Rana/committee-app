package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.UserLoanTransactions;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class UserLoanTransactionsDTO extends BaseDTO{
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

    public UserLoanTransactions dtoToUserLoanTransaction(){
        UserLoanTransactions transactions = new UserLoanTransactions();
        BeanUtils.copyProperties(this,transactions);
        return transactions;
    }
}
