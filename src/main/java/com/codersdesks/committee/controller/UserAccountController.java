package com.codersdesks.committee.controller;

import com.codersdesks.committee.dto.UserAccountDTO;
import com.codersdesks.committee.exception.NoRecordFoundException;
import com.codersdesks.committee.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userAccount/v1")
@RequiredArgsConstructor
@Slf4j
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping("/create")
    public UserAccountDTO create(@RequestBody UserAccountDTO userAccount){
        log.info("create user account {} ",userAccount);
        return userAccountService.createUserAccount(userAccount);
    }

    @GetMapping("/findById/{id}")
    public UserAccountDTO findById(@PathVariable long id) throws NoRecordFoundException {
        return userAccountService.fetchUserAccountById(id);
    }

    @GetMapping("/findByIdCommitteeId/{committeeId}")
    public List<UserAccountDTO> findUserAccountByCommitteeId(@PathVariable long committeeId) throws NoRecordFoundException {
        return userAccountService.fetchUserAccountByCommitteeId(committeeId);
    }
}
