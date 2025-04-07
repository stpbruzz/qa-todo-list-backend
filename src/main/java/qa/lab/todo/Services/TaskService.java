package qa.lab.todo.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qa.lab.todo.DTOs.createTaskDTO;
import qa.lab.todo.Entities.Task;
import qa.lab.todo.Enums.Priority;
import qa.lab.todo.Enums.Status;
import qa.lab.todo.Repositories.TaskRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(Status status, Priority priority, String sortOrder) {
        if (status == null && priority == null) {
            if ("oldest".equals(sortOrder)) {
                return taskRepository.findAllByOrderByCreationDateAsc();
            } else {
                return taskRepository.findAllByOrderByCreationDateDesc();
            }
        }
        return taskRepository.findFilteredTasks(status, priority, sortOrder);
    }

    public Task createTask(createTaskDTO dto) {
        return taskRepository.save(Task.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .deadline(dto.getDeadline())
                .priority(dto.getPriority() != null ? dto.getPriority() : Priority.MEDIUM)
                .status(Status.ACTIVE)
                .creationDate(LocalDate.now())
                .build()
        );
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }
}
