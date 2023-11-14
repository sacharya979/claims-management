package com.libertymutual.claimsmanagement.repository;

import com.libertymutual.claimsmanagement.entities.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository {
    // Create a new task or update an existing one
    Task save(Task task);

    // Retrieve a specific task by its ID
    Task findById(String id);

    // Find all tasks associated with a specific claim
    List<Task> findByClaimId(String claimId);

    // Retrieve tasks based on their status (e.g., "Open", "Completed")
    List<Task> findByStatus(String status);

    // Retrieve all tasks due on or before a specific date
    List<Task> findByDueDate(LocalDate dueDate);

    // Optional: Delete a task by its ID
    void deleteById(String id);

    // Additional methods as needed for specific use cases...
}
