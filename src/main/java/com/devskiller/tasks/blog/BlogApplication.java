package com.devskiller.tasks.blog;

import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class BlogApplication implements CommandLineRunner {
	private final PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Post post = new Post();
		post.setContent("test");
		post.setCreationDate(LocalDateTime.now());
		post.setTitle("test1");
		postRepository.save(post);
	}
}
