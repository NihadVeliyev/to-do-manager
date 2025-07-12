package az.edu.turing.todomanager.service;


import az.edu.turing.todomanager.dto.TaskRequest;
import az.edu.turing.todomanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();
    Task createTask(TaskRequest task);
    Optional<Task> getTaskById(long taskId);
    Task updateTask(Long taskId,Task updatedTask);
    void deleteTask(Long taskId);


}
