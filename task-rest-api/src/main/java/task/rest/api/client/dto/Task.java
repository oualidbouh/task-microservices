package task.rest.api.client.dto;

import task.io.core.dto.TaskDTO;

public class Task extends TaskDTO {

    private UserDTO userDTO;

    public Task(Long id,String name, Boolean done, UserDTO userDTO) {
        super(id,name, done);
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
