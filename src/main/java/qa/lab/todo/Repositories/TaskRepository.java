package qa.lab.todo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import qa.lab.todo.Entities.Task;
import qa.lab.todo.Enums.Priority;
import qa.lab.todo.Enums.Status;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findAllByOrderByCreationDateAsc();
    List<Task> findAllByOrderByCreationDateDesc();

    @Query("SELECT t FROM Task t WHERE " +
            "(:status IS NULL OR t.status = :status) AND " +
            "(:priority IS NULL OR t.priority = :priority) " +
            "ORDER BY " +
            "CASE WHEN :sortOrder = 'newest' THEN t.creationDate END DESC, " +
            "CASE WHEN :sortOrder = 'oldest' THEN t.creationDate END ASC")
    List<Task> findFilteredTasks(
            @Param("status") Status status,
            @Param("priority") Priority priority,
            @Param("sortOrder") String sortOrder);
}
