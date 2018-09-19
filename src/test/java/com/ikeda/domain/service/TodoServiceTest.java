package com.ikeda.domain.service;

import com.ikeda.domain.model.Todo;
import com.ikeda.mapper.TodoMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TodoServiceTest {
  @Autowired
  private TodoService todoService;

  @MockBean
  private TodoMapper todoMapper;

  private Todo todo;

  @Before
  public void setUp() {
    // 準備：テストデータ
    todo = new Todo();
    todo.setId(0L);
    todo.setTitle("Sample Title");
    todo.setDetails("Sample Details");
    todo.setFinished(false);
  }

  @Test
  public void データの挿入() {
    // 実行
    String result = todoService.save(todo);
    // 検証
    assertThat(result).isEqualTo("Insert");
  }
}