package liga.medical.personservice.core.security.service;

import liga.medical.personservice.core.security.model.User;
import liga.medical.personservice.core.security.model.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);

    User findByUsername(String username);

    List<UserDto> getUsers();

    boolean deleteUser(Long userId);
}
