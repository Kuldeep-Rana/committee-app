package com.codersdesks.committee.repository;

import com.codersdesks.committee.entity.UserLoanTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoanTransactionRepository extends JpaRepository<UserLoanTransactions, Long> {

}
