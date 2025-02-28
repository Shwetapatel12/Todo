package com.example.todo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}


	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable Long id) {
		return todoService.getTodoById(id);
	}

	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
		return todoService.updateTodo(id, todoDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteTodoById(@PathVariable Long id) {
		todoService.deleteTodoById(id);
	}

	@GetMapping("/view")
	public String viewTodos(Model model) {
		model.addAllAttributes(todoService.getAllTodos());
		return "shweta";
	}

	// @PatchMapping("/product/{id}")
	// public Todo updatePartialTodo(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
	// 	return todoService.updateTodo(id, null);
	// }

}
