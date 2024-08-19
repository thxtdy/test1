package com.tenco.blog.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Write {
	
	private int id;
	private String author;
	private String title;
	private String content;
	
}
