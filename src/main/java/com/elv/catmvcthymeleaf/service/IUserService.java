package com.elv.catmvcthymeleaf.service;

import com.elv.catmvcthymeleaf.entities.User;
import com.elv.catmvcthymeleaf.web.UserDto;
import com.elv.catmvcthymeleaf.web.error.UserAlreadyExistException;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;
}
