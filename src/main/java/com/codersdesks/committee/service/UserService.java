package com.codersdesks.committee.service;

import com.codersdesks.committee.dto.UserDTO;
import com.codersdesks.committee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO createUser(UserDTO dto) {
        return userRepository.save(dto.dtoToUser()).userToDto();
    }

    public UserDTO findById(long id) {
        return userRepository.findById(id).get().userToDto();
    }
}
