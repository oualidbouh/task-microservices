package task.io.consumer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "desciption")
    private String desription;

    @Column(name = "done")
    private boolean done;

    @Column(name = "created_by_user_id")
    private Long createdBy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return done == task.done &&
                Objects.equals(id, task.id) &&
                Objects.equals(desription, task.desription) &&
                Objects.equals(createdBy, task.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desription, done, createdBy);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", desription='" + desription + '\'' +
                ", done=" + done +
                ", createdBy=" + createdBy +
                '}';
    }
}
