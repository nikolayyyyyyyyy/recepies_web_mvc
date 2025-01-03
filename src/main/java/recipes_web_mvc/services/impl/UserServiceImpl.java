package recipes_web_mvc.services.impl;
import org.springframework.stereotype.Service;
import recipes_web_mvc.config.UserSession;
import recipes_web_mvc.models.dtos.UserDTO;
import recipes_web_mvc.models.entities.User;
import recipes_web_mvc.repositoies.UserRepository;
import recipes_web_mvc.services.UserService;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserSession userSession;

    public UserServiceImpl(UserRepository userRepository, UserSession userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }


    @Override
    public boolean createUser(UserDTO userDTO) {

        if(userRepository.findByEmail(userDTO.getPassword()) != null
        || userRepository.findByUsername(userDTO.getUsername()) != null){

            return false;
        }

        userRepository.save(mapToUser(userDTO));
        return true;
    }

    @Override
    public boolean login(UserDTO userDTO) {
        User user = this.userRepository.findByUsername(userDTO.getUsername());

        if(user == null){

            return false;
        }

        if(!Objects.equals(user.getPassword(), userDTO.getPassword())){

            return false;
        }

        userSession.login(userDTO.getId(),userDTO.getUsername());
        return true;
    }

    private User mapToUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}