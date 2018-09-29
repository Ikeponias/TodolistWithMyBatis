package com.ikeda.app.todo;

import java.util.List;

import com.ikeda.domain.model.Todo;
import com.ikeda.domain.service.TodoService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TodoControllerTest {
  private MockMvc mockMvc;
  private ResultActions resultActionsTodoIndex;

  @Autowired
  TodoController todoController;

  @MockBean
  TodoService todoService;

  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
    resultActionsTodoIndex = mockMvc.perform(get("/todo"));
  }

  @Test
  public void Indexのリクエストに対してレスポンスのステータスコードが正しいか() throws Exception {
    resultActionsTodoIndex.andExpect(status().isOk());
  }

  @Test
  public void Indexのリクエストに対してIndexのViewを返しているか() throws Exception {
    resultActionsTodoIndex.andExpect(view().name("todo/index"));
  }

  @Test
  public void Indexのリクエストに対してModelに正しいtodosを詰められているか() throws Exception {
    List<Todo> todos = todoService.selectAll();
    resultActionsTodoIndex.andExpect(model().attribute("todos", todos));
  }
}