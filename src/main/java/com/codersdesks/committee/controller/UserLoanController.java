package com.codersdesks.committee.controller;

import com.codersdesks.committee.dto.UserLoanDetailsDTO;
import com.codersdesks.committee.exception.NoRecordFoundException;
import com.codersdesks.committee.service.UserLoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userLoan/v1")
@RequiredArgsConstructor
@Slf4j
public class UserLoanController {
    private final UserLoanService loanService;

    @PostMapping("/create")
    public UserLoanDetailsDTO createUser(@RequestBody UserLoanDetailsDTO loanDetailsDTO) {
        return loanService.save(loanDetailsDTO);
    }

    @PostMapping("/findByUserId/{userId}")
    public UserLoanDetailsDTO createUser(@PathVariable long userId) throws NoRecordFoundException {
        return loanService.fetchByUserId(userId);
    }
}
