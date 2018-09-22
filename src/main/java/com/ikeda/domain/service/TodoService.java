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
  public List<Todo> selectAll() {
    List<Todo> todos = todoMapper.selectAll();

    return todos;
  }

  @Transactional(readOnly = true)
  public Todo selectById(Long id) {
    Todo todo = todoMapper.selectById(id);

    return todo;
  }

  // SharedService実装後そちらに記載しこちらは削除
  @Transactional
  public Boolean save(Todo todo) {
    if (todoMapper.selectById(todo.getId()) == null) {
      todoMapper.insert(todo);

      return false;
    }

    todoMapper.update(todo);

    return true;
  }

  @Transactional
  public Boolean insert(Todo todo) {
    todoMapper.insert(todo);

    return true;
  }

  @Transactional
  public Boolean update(Todo todo) {
    todoMapper.update(todo);

    return true;
  }

  @Transactional
  public Long delete(Long id) {
    todoMapper.deleteById(id);

    return id;
  }

}