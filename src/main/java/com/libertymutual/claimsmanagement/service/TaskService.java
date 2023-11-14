package com.libertymutual.claimsmanagement.service;

import com.libertymutual.claimsmanagement.entities.Task;
import java.util.List;

public interface TaskService {
    Task createOrUpdateTask(Task task);
    Task getTaskById(String id);
    List<Task> getTasksByClaimId(String claimId);
    List<Task> getTasksByStatus(String status);
    void deleteTask(String id);
    // Additional methods as needed...
}
