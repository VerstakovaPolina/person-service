package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.Illness;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IllnessMapper {

    @Select("select * from illness; ")
    List<Illness> listIllness();

    @Select("select * from illness where id = #{id};")
    Illness getIllnessById(@Param("id") long id);

    @Insert("insert into illness values(#{id},#{medicalCardId},#{typeId},#{heaviness},#{appearanceDttm},#{recoveryDt});")
    void addIllnessInDB(Illness illness);

}
