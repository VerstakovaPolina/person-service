package liga.medical.personservice.core.security.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    public Long id;

    public String username;

    public Set<RoleDto> roles;
}
