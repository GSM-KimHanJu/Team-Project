package com.example.ghskfen.rpdlrlagkwsn.service;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.model.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class Postservice {
    private final List<Post> posts = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Post createPost(Post post) {
        post.setId(counter.incrementAndGet());
        posts.add(post);
        return post;
    }

    public List<Post> getPosts() {
        return posts;
    }
}

