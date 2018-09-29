package com.ikeda.app.todo;

import java.util.List;

import com.ikeda.domain.model.Todo;
import com.ikeda.domain.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api/todo")
public class TodoAPIController {

  @Autowired
  TodoService todoService;

  @GetMapping(value = "", produces = "application/json")
  @ResponseBody
  @ApiOperation(value = "全てのTODOを取得する", notes = "JSON形式で返る")
  public ResponseEntity<List<Todo>> indexJson() {
    return ResponseEntity.ok(todoService.selectAll());
  }
}