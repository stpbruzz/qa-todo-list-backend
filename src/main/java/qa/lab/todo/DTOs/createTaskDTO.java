package qa.lab.todo.DTOs;

import lombok.Getter;
import qa.lab.todo.Enums.Priority;

import java.time.LocalDate;

@Getter
public class createTaskDTO {
    private String name;
    private String description;
    private LocalDate deadline;
    private Priority priority;
}
