package com.HAVOK.TL_API.Controller;

import com.HAVOK.TL_API.Model.Task;
import com.HAVOK.TL_API.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * User id parameter -> userId=
     * Task id parameter -> taskId=
     */

    @GetMapping(path = "/get")
    public List<Task> get(@RequestParam(required = false, name = "taskId") Integer taskId,
                          @RequestParam(required = false, name = "userId") Integer userId) {

        if (taskId != null) {
            Optional<Task> val = this.ts.getByTaskId(taskId);
            return val.stream().toList();
        } else if (userId != null) {
            return this.ts.getByUserId(userId);
        } else {
            return this.ts.get();
        }
    }

    // Endpoint to create a task -> http://localhost:8080/API/v1/tasks/create
    @PostMapping(path = "/create")
    public void create(@RequestBody Task t) {
        this.ts.create(t);
    }

    /*
     * Endpoints to delete a task by user id or task id
     *
     * Base endpoint -> http://localhost:8080/API/v1/tasks/delete
     * Task id parameter -> taskId=
     * User id parameter -> userId=
     */
    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam(required = false, name = "taskId") Integer taskId,
                       @RequestParam(required = false, name = "userId") Integer userId) {
        if (taskId != null) {
            this.ts.deleteByTaskId(taskId);
        } else if (userId != null) {
            this.ts.deleteByUserId(userId);
        }
    }
}
