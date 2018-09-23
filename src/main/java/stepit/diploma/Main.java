package stepit.diploma;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import stepit.diploma.dao.Dao;
import stepit.diploma.dao.mapper.TestMapper;

import javax.annotation.PostConstruct;

@Component
public class Main {

    @Autowired
    TestMapper testMapper;

    ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    public void init() throws JsonProcessingException {
        testMapper.getAll();
    }
}
