package com.ikeda.app.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ikeda.domain.model.Todo;
import com.ikeda.domain.service.TodoService;

@Controller
@RequestMapping("todo")
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		List<Todo> todos = todoService.findAll();

		model.addAttribute("todos", todos);
		model.addAttribute("todoForm", new Todo());

		return "todo/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Todo todoForm) {
		todoService.save(todoForm);

		return "redirect:";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String update(@ModelAttribute Todo todoForm) {
		todoService.save(todoForm);

		return "redirect:/todo";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		todoService.delete(id);

		return "redirect:/todo";
	}
}
