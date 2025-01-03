package recipes_web_mvc.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipes_web_mvc.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);
    public User findByEmail(String email);
}
