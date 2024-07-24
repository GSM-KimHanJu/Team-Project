package com.example.ghskfen.rpdlrlagkwsn.persrsr;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.model.UserRequest;
import com.example.ghskfen.rpdlrlagkwsn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Testcontroller {

 @Autowired
 private UserService userService;

 @GetMapping("/{id}")
 public Long test( @PathVariable Long id){
  return id;
 }
 @PostMapping
 public String post(@RequestBody UserRequest userRequest){
  userService.save(userRequest);
  return "age"+ userRequest.age;
 }
}


