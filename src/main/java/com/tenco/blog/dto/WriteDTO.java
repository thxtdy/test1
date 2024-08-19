package com.tenco.blog.dto;

import com.tenco.blog.repository.model.Write;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WriteDTO {
	
	private int id;
	private String author;
	private String title;
	private String content;
	
	public Write toWrite() {
		return Write.builder()
				.id(id)
				.author(author)
				.title(title)
				.content(content)
				.build();
	}
	
}
