package com.ikeda.app.todo;

import java.util.List;

import com.ikeda.domain.model.Todo;
import com.ikeda.domain.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoAPIController {

  @Autowired
  TodoService todoService;

  @GetMapping(value = "", produces = "application/json")
  @ApiOperation(value = "全てのTODOを取得する", notes = "", response = Todo.class, responseContainer = "List")
  public ResponseEntity<List<Todo>> indexJson() {
    return ResponseEntity.ok(todoService.selectAll());
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  @ApiOperation(value = "URLパラメータで指定されたIDを持つTODOを取得する", notes = "IDはPK", response = Todo.class)
  @ApiParam(value = "ID", required = true)
  public ResponseEntity<Todo> showJson(@PathVariable("id") Long id) {
    return ResponseEntity.ok(todoService.selectById(id));
  }
}