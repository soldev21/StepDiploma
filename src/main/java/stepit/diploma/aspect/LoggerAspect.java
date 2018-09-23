package stepit.diploma.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static stepit.diploma.logger.Log.info;


@Aspect
@Component
public class LoggerAspect {

    ObjectMapper mapper = new ObjectMapper();

    @Around("execution(* stepit.diploma.controller.*.*(..)) || execution(* stepit.diploma.service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = buildMethodName(joinPoint);
        String requsetData = buildRequestData(joinPoint);
        info("REQUEST "+methodName.concat(" ").concat(requsetData));

        Object returnValue = joinPoint.proceed();
        info("RESPONSE "
                +methodName
                .concat(" ")
                .concat(mapper
                        .writeValueAsString(returnValue)));
        return returnValue;
    }

    private String buildMethodName(JoinPoint joinPoint){
        StringBuffer buffer = new StringBuffer();
        buffer.append(joinPoint.getTarget().getClass().getSimpleName());
        buffer.append(".");
        buffer.append(joinPoint.getSignature().getName()+" ");
        return buffer.toString();
    }

    private String buildRequestData(JoinPoint joinPoint) throws JsonProcessingException {
        StringBuffer buffer = new StringBuffer();
        Object[] args = joinPoint.getArgs();
        for (Object o:args){
            buffer.append(mapper.writeValueAsString(o));
        }
        if (args.length>0){
            buffer.deleteCharAt(buffer.length()-1);
        }
        return buffer.toString();
    }
}
