package stepit.diploma.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stepit.diploma.dao.mapper.TestMapper;
import stepit.diploma.model.Test;

import java.util.List;

@Component
public class Dao {


    private TestMapper mapper;

    public List<Test> getAllTest(){
        return mapper.getAll();
    }
}
