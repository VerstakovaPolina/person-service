package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {
    @Select("select * from address; ")
    List<Address> listAddress();

    @Select("select * from address where id = #{id};")
    Address getAddressById(@Param("id") long id);

    @Insert("insert into address values(#{id},#{contactId},#{countryId},#{city},#{index},#{street},#{building},#{flat});")
    void addAddressInDB(Address address);

}

