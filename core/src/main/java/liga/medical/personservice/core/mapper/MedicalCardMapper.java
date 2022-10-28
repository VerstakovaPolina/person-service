package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.MedicalCard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalCardMapper {
    @Select("select * from medicalCard; ")
    List<MedicalCard> listMedicalCard();

    @Select("select * from medicalCard where id = #{id};")
    MedicalCard getMedicalCardById(@Param("id") long id);

    @Insert("insert into medicalCard values(#{id},#{clientStatus},#{medStatus},#{registryDate},#{comment});")
    void addMedicalCardInDB(MedicalCard medicalCard);

}

