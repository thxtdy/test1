package com.tenco.blog.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.blog.dto.WriteDTO;
import com.tenco.blog.handler.exception.DataDeliveryException;
import com.tenco.blog.repository.interfaces.WriteRepository;

@Service
public class WriteService {
	private final WriteRepository writeRepository;

	public WriteService(WriteRepository writeRepository) {
		this.writeRepository = writeRepository;
	}

	public List<WriteDTO> getAllPosts() {
		return writeRepository.getAllPosts();
	}

	@Transactional
	public void writePost(WriteDTO dto) {
		int result = 0;

		try {
			result = writeRepository.insert(dto.toWrite());
		} catch (Exception e) {
			throw new DataDeliveryException("오류 떴어요", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (result == 0) {
			throw new DataDeliveryException("SQL에서 문제 떴어요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	public void updatePost(WriteDTO dto) {
		int result = 0;

		try {
			result = writeRepository.updateById(dto.toWrite());
		} catch (Exception e) {
			throw new DataDeliveryException("오류 떴어요", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (result == 0) {
			throw new DataDeliveryException("SQL에서 문제 떴어요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	public void deletePost(int id) {
		int result = 0;

		try {
			result = writeRepository.deleteById(id);
		} catch (Exception e) {
			throw new DataDeliveryException("오류 떴어요", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (result == 0) {
			throw new DataDeliveryException("SQL에서 문제 떴어요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public WriteDTO getPostById(int id) {
		WriteDTO dto = null;
		try {
			dto = writeRepository.getPostById(id);
		} catch (Exception e) {
			throw new DataDeliveryException("오류 떴어요", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return dto;
	}

}
