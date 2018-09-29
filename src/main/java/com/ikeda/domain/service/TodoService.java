package com.ikeda.domain.service;

import java.util.List;

import com.ikeda.domain.model.Todo;
import com.ikeda.mapper.TodoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {
  @Autowired
  TodoMapper todoMapper;

  @Transactional(readOnly = true)
  public List<Todo> selectAll() {
    return todoMapper.selectAll();
  }

  @Transactional(readOnly = true)
  public Todo selectById(Long id) {
    return todoMapper.selectById(id);
  }

  // SharedService実装後そちらに記載しこちらは削除
  @Transactional
  public boolean save(@NonNull final Todo todo) {
    if (todoMapper.selectById(todo.getId()) == null) {
      return todoMapper.insert(todo);
    }

    return todoMapper.update(todo);
  }

  @Transactional
  public boolean insert(Todo todo) {
    return todoMapper.insert(todo);
  }

  @Transactional
  public boolean update(Todo todo) {
    return todoMapper.update(todo);
  }

  @Transactional
  public boolean delete(Long id) {
    return todoMapper.deleteById(id);
  }

}