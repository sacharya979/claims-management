package com.libertymutual.claimsmanagement.service.impl;

import com.libertymutual.claimsmanagement.entities.Task;
import com.libertymutual.claimsmanagement.repository.TaskRepository;
import com.libertymutual.claimsmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createOrUpdateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getTasksByClaimId(String claimId) {
        return taskRepository.findByClaimId(claimId);
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    // Additional methods as needed...
}
