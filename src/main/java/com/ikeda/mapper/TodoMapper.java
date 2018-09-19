package com.ikeda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ikeda.domain.model.Todo;

@Mapper
public interface TodoMapper {
	void insert(Todo todo);

	void update(Todo todo);

	Todo selectById(Long id);

	List<Todo> selectAll();

	void deleteById(Long id);
}
