package liga.medical.personservice.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("illness")
public class Illness {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @MappedCollection(idColumn = "id", keyColumn = "medical_card_id")
    private MedicalCard medicalCard;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long typeId;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String heaviness;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp appearanceDttm;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Date recoveryDt;

}
