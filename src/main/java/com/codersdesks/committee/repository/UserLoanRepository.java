package com.codersdesks.committee.repository;

import com.codersdesks.committee.entity.UserLoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoanRepository extends JpaRepository<UserLoanDetails, Long> {

}
