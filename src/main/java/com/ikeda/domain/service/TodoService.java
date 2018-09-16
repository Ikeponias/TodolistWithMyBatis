package com.ikeda.domain.service;

import java.util.List;

import com.ikeda.domain.model.Todo;
import com.ikeda.mapper.TodoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {
  @Autowired
  TodoMapper todoMapper;

  @Transactional(readOnly = true)
  public List<Todo> findAll() {
    List<Todo> todos = todoMapper.selectAll();

    return todos;
  }

  @Transactional
  public void save(Todo todo) {
    if (todoMapper.selectById(todo.getId()) == null) {
      todoMapper.insert(todo);
      return;
    }
    todoMapper.update(todo);
  }

  @Transactional
  public void delete(Long id) {
    todoMapper.deleteById(id);
  }

}