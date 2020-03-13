package com.blogspot.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogspot.main.model.Post;
import com.blogspot.main.repository.BlogRepository;
import com.blogspot.main.services.PostService;

@Service
public class PostServiceIMPL implements PostService {

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public List<Post> findAll() {
		return blogRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		return blogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return blogRepository.save(post);
	}

}
