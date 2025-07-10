package az.edu.turing.todomanager.controller;

import az.edu.turing.todomanager.model.Task;
import az.edu.turing.todomanager.service.TaskService;
import az.edu.turing.todomanager.service.impl.TaskServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskServiceImpl taskServiceImpl;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

@PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);

}
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        try {
            Task task = taskService.updateTask(id, updatedTask);
            return ResponseEntity.ok(task);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
