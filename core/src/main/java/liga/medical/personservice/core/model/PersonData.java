package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
public class PersonData {

    @Id
    @NonNull
    private long id;

    @NonNull
    private String lastName;

    @NonNull
    private String firstName;

    @NonNull
    private java.sql.Date birthDt;

    private long age;

    @NonNull
    private String sex;

    @NonNull
    private long contactId;

    @NonNull
    private long medicalCardId;

    private long parentId;

}
