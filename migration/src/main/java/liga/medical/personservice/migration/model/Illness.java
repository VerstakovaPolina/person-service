package liga.medical.personservice.migration.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
public class Illness {

    @Id
    @NonNull
    private long id;

    @NonNull
    private long medicalCardId;

    private long typeId;

    private String heaviness;

    @NonNull
    private java.sql.Timestamp appearanceDttm;

    private java.sql.Date recoveryDt;

}
