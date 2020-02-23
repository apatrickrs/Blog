package com.blogspot.main.services;

import java.util.List;

import com.blogspot.main.model.Post;

public interface PostService {

	List<Post> findAll();

	Post findById(Long id);

	Post save(Post post);
}
