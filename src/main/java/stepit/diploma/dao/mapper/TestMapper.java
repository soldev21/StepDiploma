package stepit.diploma.dao.mapper;
//
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import stepit.diploma.model.Test;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("Select * from test")
    List<Test> getAll();
}
