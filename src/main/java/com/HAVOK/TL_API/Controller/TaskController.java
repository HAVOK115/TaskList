package com.HAVOK.TL_API.Controller;

import com.HAVOK.TL_API.Model.Task;
import com.HAVOK.TL_API.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "/API/v1/tasks")
public class TaskController {
    @Autowired
    TaskService ts;

    // Task methods
    @GetMapping(path = "/get")
    public List<Task> get(){
        return this.ts.get();
    }

    @GetMapping(path = "/get/{id}")
    public Optional<Task> getById(@RequestParam(name = "id") Integer id){
        return this.ts.getById(id);
    }
}
