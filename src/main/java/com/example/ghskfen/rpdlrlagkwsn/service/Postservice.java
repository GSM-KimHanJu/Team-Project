package com.example.ghskfen.rpdlrlagkwsn.service;

import com.example.ghskfen.rpdlrlagkwsn.exception.ResourceNotFoundException;
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
    public String deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return "게시글 id= " + id + " 삭제 성공";
        } else {
            return "게시글 id= " + id + "를 찾을 수 없습니다";
        }
    }

    public Postservice(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post updatePost(Long id, Post postDetails) throws ResourceNotFoundException {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 게시글 id=" + id + "를 찾을 수 없습니다"));

        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());

        return postRepository.save(post);
    }
}

