package com.todo.todo_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Boolean updateTodo(Todo todo){
        Long ExistingId = todo.getId();
        if(todoRepository.existsById(ExistingId)){
            todo.setId(ExistingId);
            todoRepository.save(todo);
            return true;
        }
        return false;
    }
    public Boolean changeCheckBox(Long id, boolean checked) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setChecked(checked); // or whatever your checkbox field is called
            todoRepository.save(todo);
            return true;
        }
        return false;
    }


    public Boolean deleteTodoById(Long id){
        if (todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
