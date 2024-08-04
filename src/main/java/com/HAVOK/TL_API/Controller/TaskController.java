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
    * Endpoints to get the tasks by user id, task id or none of them
    *
    * Base endpoint -> http://localhost:8080/API/v1/tasks/get
    * User id parameter -> user_id=
    * Task id parameter -> task_id=
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

    /*
     * Endpoints to delete a task by user id or task id
     *
     * Base endpoint -> http://localhost:8080/API/v1/tasks/delete
     * Task id parameter -> task_id=
     * User id parameter -> user_id=
     */
    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam(required = false, name = "task_id") Integer task,
                       @RequestParam(required = false, name = "user_id") Integer user){
        if(task != null){
            this.ts.deleteByTaskId(task);
        }else if(user != null){
            this.ts.deleteByUserId(user);
        }
    }
}
