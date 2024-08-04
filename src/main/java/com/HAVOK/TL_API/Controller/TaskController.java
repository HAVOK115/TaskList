package com.HAVOK.TL_API.Controller;

import com.HAVOK.TL_API.Model.Task;
import com.HAVOK.TL_API.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "/API/v1/tasks")
public class TaskController {
    @Autowired
    TaskService ts;

    /*
    * Endpoints that gets the tasks by user id, task id or none of them
    *
    * Returns all the tasks -> http://localhost:8080/API/v1/tasks/get
    * Returns all the task from one user -> http://localhost:8080/API/v1/tasks/get?user_id={}
    * Returns a specific task -> http://localhost:8080/API/v1/tasks/get?task_id={}
    */

    @GetMapping(path = "/get")
    public List<Task> get(@RequestParam(required = false) Integer task_id, @RequestParam(required = false) Integer user_id){
        List<Task> res = null;

        if(task_id != null){
            Optional<Task> val = this.ts.getByTaskId(task_id);
            res = val.stream().toList();
        }else if(user_id != null){
            res = this.ts.getByUserId(user_id);
        }else{
            res = this.ts.get();
        }
        return res;
    }

    // Endpoint to create a task -> http://localhost:8080/API/v1/tasks/create
    @PostMapping(path = "/create")
    public void create(@RequestBody Task t){
        this.ts.create(t);
    }
}
