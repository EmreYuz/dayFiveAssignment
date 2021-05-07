package com.company.dataAccess.abstracts;

import com.company.entities.concretes.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(User user);
    void login(String email, String password);
}
