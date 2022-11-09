package liga.medical.personservice.core.security.repository;

import liga.medical.personservice.core.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}