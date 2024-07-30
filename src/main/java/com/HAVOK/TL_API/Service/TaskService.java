package com.HAVOK.TL_API.Service;

import com.HAVOK.TL_API.Model.Task;
import com.HAVOK.TL_API.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository tr;

    public List<Task> get(){
        return this.tr.findAll();
    }

    public Optional<Task> getByTaskId(Integer id){
        return this.tr.findById(id);
    }

    public List<Task> getByUserId(Integer id){
        return this.tr.getTaskByUserId(id);
    }
}
