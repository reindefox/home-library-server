package com.reindefox.homelibraryserver.service;

import com.reindefox.homelibraryserver.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(int id);
    void createUser(User user);
}
