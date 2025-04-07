package qa.lab.todo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import qa.lab.todo.Enums.Priority;
import qa.lab.todo.Enums.Status;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    @Size(min = 4, message = "длина названия >= 4 символов")
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
