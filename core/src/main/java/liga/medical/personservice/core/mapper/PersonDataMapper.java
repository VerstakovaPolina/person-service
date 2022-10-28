package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.PersonData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonDataMapper {
    @Select("select * from personData; ")
    List<PersonData> listPersonData();

    @Select("select * from personData where id = #{id};")
    PersonData getPersonDataById(@Param("id") long id);

    @Insert("insert into personData values(#{id},#{phoneNumber},#{email},#{profileLink});")
    void addPersonDataInDB(PersonData personData);

}

