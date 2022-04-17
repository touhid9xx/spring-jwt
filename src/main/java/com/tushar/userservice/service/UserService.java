package com.tushar.userservice.service;

import com.tushar.userservice.domain.Role;
import com.tushar.userservice.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);

    List<User>getUsers();

}
