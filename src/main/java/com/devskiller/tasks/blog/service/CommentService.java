package com.devskiller.tasks.blog.service;

import java.util.List;
import java.util.Optional;

import com.devskiller.tasks.blog.converter.CommentsToDto;
import com.devskiller.tasks.blog.model.Comments;
import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.repository.CommentRepository;
import com.devskiller.tasks.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 */
	public List<CommentDto> getCommentsForPost(Long postId) {
		Optional<Post> post = postRepository.findById(postId);
		List<Comments> comments = commentRepository
			.findByPost(post, Sort.by(Sort.Direction.ASC, "creationDate"));
		return CommentsToDto.getCommentsDto(comments);
	}

	/**
	 * Creates a new comment
	 *
	 * @param newCommentDto data of new comment
	 * @return id of the created comment
	 * @throws IllegalArgumentException if there is no blog post for passed newCommentDto.postId
	 */
	public Long addComment(NewCommentDto newCommentDto) {
		Post post = postRepository.findById(newCommentDto.getPostId())
			.orElseThrow(() -> new IllegalArgumentException("post not found"));

		Comments comments = new Comments()
			.setComment(newCommentDto.getContent())
			.setAuthor(newCommentDto.getAuthor())
			.setPost(post);
		Comments postComment = commentRepository.save(comments);
		return postComment.getId();
	}
}
