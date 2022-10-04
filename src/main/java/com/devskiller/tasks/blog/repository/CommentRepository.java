package com.devskiller.tasks.blog.repository;

import com.devskiller.tasks.blog.model.Comments;
import com.devskiller.tasks.blog.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comments, Long> {

	List<Comments> findByPost(Optional<Post> post, Sort sort);
}
