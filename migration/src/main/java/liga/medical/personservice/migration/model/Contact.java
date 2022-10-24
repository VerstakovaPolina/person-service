package liga.medical.personservice.migration.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
public class Contact {

    @Id
    @NonNull
    private long id;

    @NonNull
    private String phoneNumber;

    private String email;

    private String profileLink;

}
