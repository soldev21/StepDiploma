package stepit.diploma.service;

import org.springframework.stereotype.Service;
import stepit.diploma.annotation.ServiceMethod;

import static stepit.diploma.constant.ServiceNames.ADVERTISEMENT;


@Service(ADVERTISEMENT)
public class AdvertisementService extends AbstractService {

    @ServiceMethod
    public String save(){
        return "It is save method";
    }

    @ServiceMethod(name = "customUpdate")
    public String update(){
        return "It is update method";
    }
}
