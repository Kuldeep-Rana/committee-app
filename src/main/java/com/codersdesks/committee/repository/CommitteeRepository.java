package com.codersdesks.committee.repository;

import com.codersdesks.committee.entity.CommitteeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitteeRepository extends JpaRepository<CommitteeDetails, Long> {
}
