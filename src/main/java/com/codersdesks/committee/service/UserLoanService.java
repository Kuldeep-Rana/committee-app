package com.codersdesks.committee.service;

import com.codersdesks.committee.dto.UserLoanDetailsDTO;
import com.codersdesks.committee.entity.UserLoanDetails;
import com.codersdesks.committee.entity.UserLoanTransactions;
import com.codersdesks.committee.exception.NoRecordFoundException;
import com.codersdesks.committee.repository.CommitteeRepository;
import com.codersdesks.committee.repository.UserAccountRepository;
import com.codersdesks.committee.repository.UserLoanRepository;
import com.codersdesks.committee.repository.UserLoanTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserLoanService {
    private final UserLoanRepository loanRepository;
    private final UserLoanTransactionRepository loanTransactionRepository;
    private final CommitteeRepository committeeRepository;
    private final UserAccountRepository accountRepository;

    public UserLoanDetailsDTO save(UserLoanDetailsDTO loanDetailsDTO) {
        loanDetailsDTO.setIs_approved(false);
        loanDetailsDTO.setApproved_on(null);
        var loanDetails = loanRepository.save(loanDetailsDTO.dtoToUserLoanDetails());
        return loanDetails.userLoanDetailsToDTO();
    }

    public UserLoanDetailsDTO fetchByUserId(long userId) throws NoRecordFoundException {
        return loanRepository.findById(userId).orElseThrow(NoRecordFoundException::new).userLoanDetailsToDTO();
    }


    public void crateLoanTransaction(UserLoanDetails loanDetail, double installmentAmtPaid, double interestAmtPaid) {
        var committee = committeeRepository.findById(loanDetail.getCommittee_id()).get();
        var userAccount = accountRepository.findById(loanDetail.getCommittee_id()).get();
        var UserLoanTranx = new UserLoanTransactions();
        UserLoanTranx.setUser_loan_id(loanDetail.getUser_loan_id());
        UserLoanTranx.setLoan_amount(loanDetail.getLoan_amount());
        UserLoanTranx.setPrevious_balance_loan(loanDetail.getBalance_loan());
        UserLoanTranx.setBalance_loan(loanDetail.getBalance_loan() - installmentAmtPaid);
        UserLoanTranx.setPrincipal_amount_paid(installmentAmtPaid);
        var interestCalculated = loanDetail.getLoan_amount() * committee.getLoan_interest_rate() / 100;
        UserLoanTranx.setInterest_amount(interestCalculated);
        UserLoanTranx.setInterest_paid(interestAmtPaid);
        UserLoanTranx.setInterest_remaining(interestCalculated - interestAmtPaid);

        UserLoanTranx.setPaid_on(Timestamp.from(Instant.now()));
        UserLoanTranx.setCreated_by(-1L);
        UserLoanTranx.setCreated_on(Timestamp.from(Instant.now()));

        loanDetail.setBalance_loan(loanDetail.getBalance_loan()-installmentAmtPaid);
    }
}
