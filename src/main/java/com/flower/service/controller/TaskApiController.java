package com.flower.service.controller;

import com.flower.service.api.model.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.flower.service.api.controller.TaskApi;

@Controller
public class TaskApiController implements TaskApi {

    private final NativeWebRequest request;

    @Autowired
    public TaskApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<TaskDto>> getUserTasks(Integer userId) throws Exception {
        List<TaskDto> tasks = new ArrayList<>();
        tasks.add(taskOf(1, "Task #1 for userId: " + userId, "Connect to the Internet", TaskDto.StatusEnum.DONE, OffsetDateTime.now()));
        tasks.add(taskOf(2, "Task #2 for userId: " + userId, "Watch YouTube", TaskDto.StatusEnum.IN_PROGRESS, OffsetDateTime.now()));

        return ResponseEntity.ok(tasks);
    }

    public static TaskDto taskOf(Integer id, String title, String description,
                                 TaskDto.StatusEnum status, OffsetDateTime createdAt) {
        TaskDto task = new TaskDto();
        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setCreatedAt(createdAt);
        return task;
    }
}
