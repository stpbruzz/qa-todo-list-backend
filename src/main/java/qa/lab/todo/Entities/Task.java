package qa.lab.todo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import qa.lab.todo.Enums.Priority;
import qa.lab.todo.Enums.Status;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    @Size(min = 4)
    private String name;

    private String description;
    private LocalDate deadline;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Priority priority;

    @Column(nullable = false, updatable = false)
    private LocalDate creationDate;

    private LocalDate modificationDate;
}
