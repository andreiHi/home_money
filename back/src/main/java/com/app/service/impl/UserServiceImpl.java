package com.app.service.impl;

import com.app.entity.Users;
import com.app.entity.dto.LoginDto;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users saveUser(LoginDto loginDto) {
        Users build = Users.builder()
                .email(loginDto.getEmail())
                .password(loginDto.getPassword()).build();
        return this.userRepository.save(build);
    }
}
