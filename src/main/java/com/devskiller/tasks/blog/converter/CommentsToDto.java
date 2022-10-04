package com.devskiller.tasks.blog.converter;

import com.devskiller.tasks.blog.model.Comments;
import com.devskiller.tasks.blog.model.dto.CommentDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentsToDto {

	public static List<CommentDto> getCommentsDto(List<Comments> comments) {
		return comments.stream().map(cmm ->
				new CommentDto()
					.setComment(cmm.getComment())
					.setAuthor(cmm.getAuthor())
					.setCreationDate(cmm.getCreationDate()))
			.collect(Collectors.toList());
	}
}
