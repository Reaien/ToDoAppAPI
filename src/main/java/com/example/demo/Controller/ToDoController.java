package com.example.demo.Controller;

import com.example.demo.Model.Task;
import com.example.demo.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;
    @GetMapping(value = "/")
    public String holamundo(){
        return "Hola Mundo";
    }

    //getAll
    @GetMapping(value = "/tasks")
    public List<Task> getTask(){
        return toDoRepository.findAll();
    }

    //post
    @PostMapping(value = "/savetask")
    public String saveTask(@RequestBody Task task){
        toDoRepository.save(task);
        return "Tarea agregada";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updatedTask = toDoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setTitle(task.getDescription());
        toDoRepository.save(updatedTask);
        return "Tarea actualizada";
    }
}
