package com.example.ghskfen.rpdlrlagkwsn.persrsr.in.repository;

import com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
