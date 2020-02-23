package com.blogspot.main.util;

import java.time.LocalDate;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogspot.main.model.Post;
import com.blogspot.main.repository.BlogRepository;

@Component
public class PutData {

	@Autowired
	private BlogRepository blogRepository;

	@PostConstruct
	public void savePosts() {

		blogRepository.deleteAll();

		Post post1 = new Post("Docker", "Andrew", LocalDate.now(),
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
		Post post2 = new Post("API", "Zeca", LocalDate.now(),
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

		blogRepository.saveAll(Arrays.asList(post1, post2));
	}
}
