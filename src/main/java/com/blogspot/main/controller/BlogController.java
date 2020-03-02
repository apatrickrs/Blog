package com.blogspot.main.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blogspot.main.model.Post;
import com.blogspot.main.services.PostService;

@Controller
public class BlogController {

	@Autowired
	private PostService postService;

	@GetMapping(value = "/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}

	@GetMapping(value = "/posts/{id}")
	public ModelAndView getPostsDetails(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = postService.findById(id);
		mv.addObject("post", post);
		return mv;
	}

	@GetMapping(value = "/newpost")
	public String getPostsForm() {
		return "postForm";
	}

	@PostMapping(value = "/newpost")
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "redirect:/newpost";
		}
		post.setDate(LocalDate.now());
		postService.save(post);
		return "redirect:/posts";
	}

}
