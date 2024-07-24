package com.example.ghskfen.rpdlrlagkwsn.service;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity.Post;
import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;


    public Post createPost(Post post) {
        return postRepository.save(post);
    }



    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Post not found with id " + id);
        }
        return false;
    }


}

