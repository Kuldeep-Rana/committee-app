package com.codersdesks.committee.config;

import com.codersdesks.committee.dto.UserAccountDTO;
import com.codersdesks.committee.response.Error;
import com.codersdesks.committee.response.ServiceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        /*UserAccountDTO u = new UserAccountDTO();
        u.setJoined_on(Timestamp.from(Instant.now()));
        System.out.println(new ObjectMapper().writeValueAsString(u));*/

        var userAccountResp = ServiceResponse.builder()
                .message("hello")
                .status(HttpStatus.OK)
                .body(new Object())
                .errors(List.of(new Error("101","sample error")))
                .build();
        System.out.println(userAccountResp);

    }
}

