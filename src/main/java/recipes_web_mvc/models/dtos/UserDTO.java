package recipes_web_mvc.models.dtos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
    @NotNull
    public long id;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String password;

    @Email
    private String email;

    public UserDTO() {
    }

    @NotNull
    public long getId() {
        return id;
    }

    public void setId(@NotNull long id) {
        this.id = id;
    }

    public @NotNull @NotBlank @Size(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @NotBlank @Size(min = 3, max = 20) String username) {
        this.username = username;
    }

    public @NotNull @NotBlank @Size(min = 3, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @NotBlank @Size(min = 3, max = 20) String password) {
        this.password = password;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }
}