package recipes_web_mvc.config;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class UserSession {
    private long id;
    private String username;

    public void login(long id,String username){
        this.id = id;
        this.username = username;
    }

    public boolean isLogged(){
        return this.id != 0;
    }
}
