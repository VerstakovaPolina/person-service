package liga.medical.personservice.core.queuelistener;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {

    @Insert("insert into signals values(#{id},#{type},#{description});")
    void addMessage(Signal signal);
}
