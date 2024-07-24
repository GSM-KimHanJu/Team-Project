package com.example.ghskfen.rpdlrlagkwsn.persrsr.in.entity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Table
@Getter
@Setter
@Entity
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String content;



}
