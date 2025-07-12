package az.edu.turing.todomanager.service.impl;

import az.edu.turing.todomanager.Enums.TaskStatus;
import az.edu.turing.todomanager.dto.TaskRequest;
import az.edu.turing.todomanager.model.Task;
import az.edu.turing.todomanager.repository.TaskRepository;
import az.edu.turing.todomanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(TaskRequest task) {
        Task task1 = new Task();
        task1.setName(task.getName());
        task1.setDueDate(task.getDueDate());
        task1.setStatus(TaskStatus.TODO);

        return taskRepository.save(task1);
    }

    @Override
    public Optional<Task> getTaskById(long taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public Task updateTask(Long taskId, Task updatedTask) {
        return taskRepository.findById(taskId)
                .map(existingTask -> {
                    existingTask.setName(updatedTask.getName());
                    existingTask.setDueDate(updatedTask.getDueDate());
                    existingTask.setStatus(updatedTask.getStatus());
                    return taskRepository.save(existingTask);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);

    }


}
