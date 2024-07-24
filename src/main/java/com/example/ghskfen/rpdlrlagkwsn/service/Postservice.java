package com.example.ghskfen.rpdlrlagkwsn.service;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity.Post;
import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class Postservice {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Page<Post> getPosts(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        return postRepository.findAll(pageable);
    }
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Post post) {
        if (post.getId() != null && postRepository.existsById(post.getId())) {
            postRepository.save(post);
        } else {
            throw new IllegalArgumentException("유효한 id가 아니잖아");
        }
    }

}

