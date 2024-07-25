package com.example.ghskfen.rpdlrlagkwsn.persrsr.in.repository;


import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
