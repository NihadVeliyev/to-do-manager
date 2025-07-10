package az.edu.turing.todomanager.controller;

import az.edu.turing.todomanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;



}
