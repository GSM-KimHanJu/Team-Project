package com.example.ghskfen.rpdlrlagkwsn.service;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.repository.PostRepository;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PostRepository userRepository;

    public void save(UserRequest user) {
        userRepository.save(user.toEntity());
    }

}


