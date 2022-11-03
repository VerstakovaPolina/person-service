package liga.medical.personservice.core.security.repository;

import liga.medical.personservice.core.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
