package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1/task", consumes = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;



    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTask());
    }

//    @RequestMapping(method = RequestMethod.GET, value = "getTaskById")
//    public List<TaskDto> getTasksByIds(@RequestBody Long taskId) {
//        return taskMapper.mapToTaskDtoList(service.getTasksByIds(taskId));
//    }

    @RequestMapping(method = RequestMethod.GET, value = "getTaskById")
    public TaskDto getTask(@RequestBody Long taskId) {
        //return new TaskDto(1L, "testTitle", "test_content");
        return taskMapper.mapToTaskDto(service.getTaskById(taskId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestBody Long taskId) {
        log.info("Delete task {}", taskId);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto task) {
        log.info("Update task {}", task);
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public void createTask(@RequestBody TaskDto task) {
        log.info("Create task for {}", task);
    }
}

