package com.app.service;

import com.app.entity.Users;
import com.app.entity.dto.LoginDto;

public interface UserService {

    Users saveUser(LoginDto loginDto);

}
