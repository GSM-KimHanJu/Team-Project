package com.example.ghskfen.rpdlrlagkwsn.persrsr.in.conroller;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity.Post;
import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.repository.PostRepository;
import com.example.ghskfen.rpdlrlagkwsn.service.Postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired

    private Postservice postservice;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/all")
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
    @GetMapping("/{post_id}/detail")
    public String getPostDetail(@PathVariable("post_id") Long postId, Model model) {
        Post post = postservice.getPostById(postId);
        model.addAttribute("post", post);
        return "sucess";
    }

    @GetMapping("/upload/{id}")
    public String getUploadForm(@PathVariable("id") Long id, Model model) {
        Post post = postservice.getPostById(id);
        model.addAttribute("post", post);
        return "uploadForm";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        Post post = postservice.getPostById(id);
        model.addAttribute("post", post);
        return "editForm";

    }



    @PostMapping("/post")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postservice.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        return postservice.deletePost(id);
    }

    public PostController(Postservice postservice) {
        this.postservice = postservice;
    }

    @PutMapping("put/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (!optionalPost.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Post existingPost = optionalPost.get();
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());

        postRepository.save(existingPost);

        return ResponseEntity.ok(existingPost);
    }

}