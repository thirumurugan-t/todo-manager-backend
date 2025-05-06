package com.todo.todo_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = {"http://localhost:3000", "https://smart-todo-tracker.netlify.app"})
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getTodoService() {
       List<Todo> todos = todoService.getAllTodos();
       return (ResponseEntity.ok(todos));
    }

    @PostMapping("/posttodo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.ok(createdTodo);
    }

    @PutMapping("/updatetodo")
    public ResponseEntity<String> updateTodo(@RequestBody Todo todo){
      Boolean updatedTodo = todoService.updateTodo(todo);
      if(updatedTodo){
          return ResponseEntity.ok("Todo has been updated successFully");
      }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/change-checkbox")
    public ResponseEntity<String> changeCheckbox(
            @RequestParam Long id,
            @RequestParam boolean checked) {

        Boolean checkboxChange = todoService.changeCheckBox(id, checked);
        if (checkboxChange) {
            return ResponseEntity.ok("Checkbox changed successfully");
        }
        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Boolean deleteTodo = todoService.deleteTodoById(id);
        if (deleteTodo){
            return ResponseEntity.ok("Todo has been Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }







}
