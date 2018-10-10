package com.ikeda.domain.service;

import java.util.List;
import java.util.Optional;

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

  @Transactional
  public boolean insert(@NonNull Todo todo) {
    return todoMapper.insert(todo);
  }

  @Transactional
  public boolean update(Long id, @NonNull Todo todo) {
    return todoMapper.update(id, todo);
  }

  @Transactional
  public boolean delete(Long id) {
    return todoMapper.deleteById(id);
  }

}