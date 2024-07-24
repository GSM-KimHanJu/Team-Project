package com.example.ghskfen.rpdlrlagkwsn.persrsr.in.conroller;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity.Post;
import com.example.ghskfen.rpdlrlagkwsn.service.Postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private Postservice postservice;
    @GetMapping
    public String getPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            Model model) {
        Page<Post> postPage = postservice.getPosts(page, size, sort);
        model.addAttribute("posts", postPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", postPage.getTotalPages());
        return "posts";
    }
    @GetMapping("/posts/{post_id}/detail")
    public String getPostDetail(@PathVariable("post_id") Long postId, Model model) {
        Post post = postservice.getPostById(postId);
        model.addAttribute("post", post);
        return "postDetail";
    }

    @GetMapping("/post/upload/{id}")
    public String getUploadForm(@PathVariable("id") Long id, Model model) {
        Post post = postservice.getPostById(id);
        model.addAttribute("post", post);
        return "uploadForm";
    }

    @GetMapping("/post/edit")
    public String getEditForm(@RequestParam("id") Long id, Model model) {
        Post post = postservice.getPostById(id);
        model.addAttribute("post", post);
        return "editForm";

    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postservice.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
}