package recipes_web_mvc.web;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import recipes_web_mvc.config.UserSession;
import recipes_web_mvc.models.dtos.UserDTO;
import recipes_web_mvc.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("userModel")
    public UserDTO userDTO(){
        return new UserDTO();
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserDTO userDTO,
                        BindingResult bindingResult){

        if(bindingResult.hasErrors()) {

            return "redirect:/login";
        }

        boolean succes = userService.login(userDTO);

        if(!succes){
            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserDTO userDTO,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return "redirect:/register";
        }

        boolean success = userService.createUser(userDTO);

        if(!success){

            return "redirect:/register";
        }

        return "redirect:/login";
    }
}