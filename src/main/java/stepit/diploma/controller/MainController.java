package stepit.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stepit.diploma.registry.AbstractFactory;
import stepit.diploma.registry.MethodRegistry;
import stepit.diploma.service.AbstractService;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

@RestController
public class MainController {

    @Autowired
    AbstractFactory factory;

    @PostMapping("/{serviceName}/{methodName}")
    public <T, E> E handlePost(@RequestBody T t,
                               @PathVariable("serviceName") String serviceName,
                               @PathVariable("methodName") String methodName) throws InvocationTargetException, IllegalAccessException {
        return (E) MethodRegistry.getRegistry().get(serviceName).get(methodName).invoke(
                factory.get(serviceName, AbstractService.class), t
        );
    }

    @GetMapping("/{serviceName}/{methodName}")
    public <E> E handleGet(@RequestParam HashMap<String, String> t,
                           @PathVariable("serviceName") String serviceName,
                           @PathVariable("methodName") String methodName) throws InvocationTargetException, IllegalAccessException {

        return t.isEmpty() ? (E) MethodRegistry.getRegistry().get(serviceName).get(methodName).invoke(
                factory.get(serviceName, AbstractService.class), null
        ) :
                (E) MethodRegistry.getRegistry().get(serviceName).get(methodName).invoke(
                        factory.get(serviceName, AbstractService.class), t
                );
    }
}
