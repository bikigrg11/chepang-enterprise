package com.sbu.model;

import org.springframework.stereotype.Repository;

/**
 * Created by bikihome on 11/28/17.
 */


@Repository
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}