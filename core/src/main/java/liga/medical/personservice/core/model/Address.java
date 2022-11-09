package liga.medical.personservice.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("address")
public class Address {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @MappedCollection(idColumn = "id", keyColumn = "contact_id")
    private Contact contact;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long countryId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String city;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long index;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String street;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String building;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String flat;

}
