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

    @Select("Select * from public.test where is_active=1 and id = #{id}")
    Test getTestById(Long id);

    @Select("select * from public.test where is_active=1")
    List<Test> getActiveTest();

    @Select("select * from public.test")
    List<Test> getAllTest();
}
