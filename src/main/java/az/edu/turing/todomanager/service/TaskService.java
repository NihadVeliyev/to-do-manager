package az.edu.turing.todomanager.service;


import az.edu.turing.todomanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();
    Task createTask(Task task);
    Optional<Task> getTaskById(long taskId);
    Task updateTask(Long taskId,Task updatedTask);

}
