package com.devskiller.tasks.blog.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
	@Id
	@GeneratedValue
	private Long id;

	private String comment;

	private String author;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime creationDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;
}
