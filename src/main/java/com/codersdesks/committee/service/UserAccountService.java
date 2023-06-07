package com.codersdesks.committee.service;

import com.codersdesks.committee.dto.UserAccountDTO;
import com.codersdesks.committee.entity.UserAccount;
import com.codersdesks.committee.exception.NoRecordFoundException;
import com.codersdesks.committee.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountDTO createUserAccount(UserAccountDTO userAccountDTO){
        UserAccount userAccount = userAccountDTO.dtoToUserAccount();
        userAccountRepository.save(userAccount);
        return userAccount.useAccountToDTO();
    }

    public UserAccountDTO fetchUserAccountById(Long id) throws NoRecordFoundException {
        return userAccountRepository.findById(id).orElseThrow(NoRecordFoundException::new)
                .useAccountToDTO();
    }
    public List<UserAccountDTO> fetchUserAccountByCommitteeId(Long committeeId){
        var accounts = userAccountRepository.findByCommitteeId(committeeId);
        return accounts.stream().map(UserAccount::useAccountToDTO).toList();
    }

}
