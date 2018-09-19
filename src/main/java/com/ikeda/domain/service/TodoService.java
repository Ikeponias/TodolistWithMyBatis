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

  @Transactional(readOnly = true)
  public Todo find(Long id) {
    Todo todo = todoMapper.selectById(id);

    return todo;
  }

  @Transactional
  public String save(Todo todo) {
    if (todoMapper.selectById(todo.getId()) == null) {
      todoMapper.insert(todo);
      return "Insert";
    }

    todoMapper.update(todo);
    return "Update";
  }

  @Transactional
  public void delete(Long id) {
    todoMapper.deleteById(id);
  }

}