package liga.medical.personservice.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("medical_card")
public class MedicalCard {

    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String clientStatus;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String medStatus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date registryDt;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String comment;

}
