package com.elv.catmvcthymeleaf.service;

import com.elv.catmvcthymeleaf.dao.UserRepository;
import com.elv.catmvcthymeleaf.entities.User;
import com.elv.catmvcthymeleaf.web.UserDto;
import com.elv.catmvcthymeleaf.web.error.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException {
        if(emailExist(accountDto.getEmail())){
            throw new UserAlreadyExistException("Il existe un compte avec cette adresse email :"
                    + accountDto.getEmail());
        }
        return null;
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
