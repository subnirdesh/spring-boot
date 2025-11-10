package com.nirdesh.taskmanager.controller;


import com.nirdesh.taskmanager.model.TaskModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private Map<Integer, TaskModel> task=new HashMap<>();

    @GetMapping
    public List<TaskModel> getAll(){
        return  new ArrayList<>(task.values());
    }

    @GetMapping("/id/{id}")
    public TaskModel getbyId(@PathVariable int id){
        return task.get(id);
    }

    @GetMapping("/search")
    public TaskModel searchById(@RequestParam int id ){
        return task.get(id);
    }

    @PostMapping
    public void createTask(@RequestBody TaskModel taskModel){
        task.put(taskModel.getId(),taskModel);
    }

    @PutMapping("/id/{id}")
    public TaskModel updateTaskById(@PathVariable int id , @RequestBody TaskModel taskModel){
        return task.put(id,taskModel);
    }

    @DeleteMapping("/id/{id}")
    public TaskModel deleteTaskById(@PathVariable int id){
        return task.remove(id);
    }

}
