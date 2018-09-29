package com.ikeda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ikeda.domain.model.Todo;

@Mapper
public interface TodoMapper {
	boolean insert(Todo todo);

	boolean update(Todo todo);

	Todo selectById(Long id);

	List<Todo> selectAll();

	boolean deleteById(Long id);
}
