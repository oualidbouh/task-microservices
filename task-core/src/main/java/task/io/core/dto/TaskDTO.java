package task.io.core.dto;

import java.io.Serializable;
import java.util.Objects;

public class TaskDTO implements Serializable{

    private static final long serialVersionUID = 6529685098267757690L;

    private Long id;
    private String name;
    private boolean done;

    public TaskDTO(Long id,String name, Boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return done == taskDTO.done &&
                Objects.equals(id, taskDTO.id) &&
                Objects.equals(name, taskDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, done);
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", done=" + done +
                '}';
    }
}
