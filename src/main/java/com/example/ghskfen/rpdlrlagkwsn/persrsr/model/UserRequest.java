package com.example.ghskfen.rpdlrlagkwsn.persrsr.model;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity.User;

public class UserRequest {
    public String username;
    public String password;
    public Long  age;

    public User toEntity() {
        User user = new User();
        user.setAge(age);
        user.setUsername(username);
        user.setPasswoard(password);

        return user;
    }
}
