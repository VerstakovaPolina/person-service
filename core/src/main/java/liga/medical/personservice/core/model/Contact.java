package liga.medical.personservice.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("contact")
public class Contact {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phoneNumber;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String profileLink;

}
