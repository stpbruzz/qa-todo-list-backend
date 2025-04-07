package qa.lab.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qa.lab.todo.DTOs.createTaskDTO;
import qa.lab.todo.Entities.Task;
import qa.lab.todo.Enums.Priority;
import qa.lab.todo.Enums.Status;
import qa.lab.todo.Services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) Priority priority,
            @RequestParam(required = false, defaultValue = "newest") String sortOrder)
    {
        return ResponseEntity.ok(taskService.getAllTasks(status, priority, sortOrder));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> updateTask(@RequestBody createTaskDTO dto) {
        return ResponseEntity.ok(taskService.createTask(dto));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllTasks() {
        taskService.deleteAllTasks();
        return ResponseEntity.ok("Список задач был очищен");
    }
}
