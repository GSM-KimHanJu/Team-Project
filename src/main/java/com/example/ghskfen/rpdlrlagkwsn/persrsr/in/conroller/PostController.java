package com.example.ghskfen.rpdlrlagkwsn.persrsr.in.conroller;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity.Post;
import com.example.ghskfen.rpdlrlagkwsn.service.Postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private Postservice postservice;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postservice.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
}