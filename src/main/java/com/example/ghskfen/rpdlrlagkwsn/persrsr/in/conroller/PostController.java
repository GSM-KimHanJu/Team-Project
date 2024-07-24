package com.example.ghskfen.rpdlrlagkwsn.persrsr.in.conroller;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.model.Post;
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
    private Postservice postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
