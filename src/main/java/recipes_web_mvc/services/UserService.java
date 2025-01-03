package recipes_web_mvc.services;

import recipes_web_mvc.models.dtos.UserDTO;

public interface UserService {

    public boolean createUser(UserDTO userDTO);
    public boolean login(UserDTO userDTO);
}
