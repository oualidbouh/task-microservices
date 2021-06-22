package task.io.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.io.consumer.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
