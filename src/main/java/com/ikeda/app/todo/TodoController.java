package com.ikeda.app.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;

import com.ikeda.domain.model.Todo;
import com.ikeda.domain.service.TodoService;

@Controller
@RequestMapping("todo")
public class TodoController {

	@Autowired
	TodoService todoService;

	@GetMapping(value = "")
	@ApiOperation(value = "全てのTODOを取得する", notes = "ページを表示")
	public String index(Model model) {
		List<Todo> todos = todoService.selectAll();

		model.addAttribute("todos", todos);
		model.addAttribute("todoForm", new Todo());

		return "todo/index";
	}

	@PostMapping(value = "")
	@ApiOperation(value = "TODOを新規作成する", notes = "ページを表示")
	public String create(@ModelAttribute Todo todoForm) {
		todoService.insert(todoForm);

		return "redirect:/todo";
	}

	@PutMapping(value = "/{id}")
	@ApiOperation(value = "TODOを更新する", notes = "ページを表示")
	public String update(@PathVariable("id") Long id, @ModelAttribute Todo todoForm) {
		todoService.update(id, todoForm);

		return "redirect:/todo";
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "TODOを削除する", notes = "ページを表示")
	public String delete(@PathVariable("id") Long id) {
		todoService.delete(id);

		return "redirect:/todo";
	}
}
