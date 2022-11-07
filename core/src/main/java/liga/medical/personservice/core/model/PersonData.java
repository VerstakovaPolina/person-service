package liga.medical.personservice.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("person_data")
public class PersonData {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date birthDt;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long age;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sex;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @MappedCollection(idColumn = "id", keyColumn = "contact_id")
    private Contact contact;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @MappedCollection(idColumn = "id", keyColumn = "medical_card_id")
    private MedicalCard medicalCard;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long parentId;

}
