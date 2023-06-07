package com.codersdesks.committee.repository;

import com.codersdesks.committee.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Query("from UserAccount where committee_id =:committeeId")
    public List<UserAccount> findByCommitteeId(Long committeeId);
}
