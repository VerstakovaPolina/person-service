package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContactMapper {
    @Select("select * from contact; ")
    List<Contact> listContact();

    @Select("select * from contact where id = #{id};")
    Contact getContactById(@Param("id") long id);

    @Insert("insert into contact values(#{id},#{phoneNumber},#{email},#{profileLink});")
    void addContactInDB(Contact contact);

}

