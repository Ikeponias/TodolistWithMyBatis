package com.ikeda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.ikeda.domain.model.Todo;

@Mapper
public interface TodoMapper {
	@Insert("INSERT INTO todo (title, details, finished) VALUES (#{title}, #{details}, #{finished})")
	@Options(useGeneratedKeys = true)
	void insert(Todo todo);

	@Update("UPDATE todo SET title = #{title}, details = #{details}, finished = #{finished} WHERE id = #{id}")
	void update(Todo todo);

	@Select("SELECT * FROM todo WHERE id = #{id}")
	Todo find(int id);

	@Select("SELECT * FROM todo")
	List<Todo> findAll();

	@Delete("DELETE FROM todo WHERE id = #{id}")
	void delete(Long id);
}
