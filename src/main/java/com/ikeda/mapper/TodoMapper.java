package com.ikeda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ikeda.domain.model.Todo;

@Mapper
public interface TodoMapper {
	boolean insert(@Param("todo") Todo todo);

	boolean update(@Param("id") Long id, @Param("todo") Todo todo);

	Todo selectById(@Param("id") Long id);

	List<Todo> selectAll();

	boolean deleteById(@Param("id") Long id);
}
