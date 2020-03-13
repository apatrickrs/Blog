package com.blogspot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogspot.main.model.Post;

public interface BlogRepository extends JpaRepository<Post, Long> {

}
