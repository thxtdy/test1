package com.tenco.blog.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.blog.dto.WriteDTO;
import com.tenco.blog.repository.model.Write;
@Mapper
public interface WriteRepository {
	
	public int insert(Write write);
	public int updateById(Write write);
	public int deleteById(int id);
	public WriteDTO getPostById(int id);
	List<WriteDTO> getAllPosts();
    int countPosts();
}
