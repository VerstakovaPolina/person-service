package liga.medical.personservice.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

    @Pointcut(value = "execution(* liga.medical.personservice.core.controller.*.*(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object appLogger(ProceedingJoinPoint joinPoint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        Object[] array = joinPoint.getArgs();

        log.info("Пользователем VerstakovaPolina вызван метод "+methodName+"() класса "+ className);

        Object object = null;
        try {
            object = joinPoint.proceed();
        }catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("Результат вызова метода "+methodName+"() : "+mapper.writeValueAsString(object));
        return object;
    }

    @Pointcut(value = "execution(* liga.medical.personservice.core.queuelistener.RabbitRouterListener.*(..))")
    public void pointcutLog() {}

    @Around("pointcutLog()")
    public Object appLog(ProceedingJoinPoint joinPoint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        Object[] array = joinPoint.getArgs();

        log.info("В методе "+methodName+"() класса "+ className+"было получено сообщение: "+mapper.writeValueAsString(array));

        Object object = null;
        try {
            object = joinPoint.proceed();
        }catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("Сообщение добавлено в базу данных в таблицу signals : "+mapper.writeValueAsString(object));
        return object;
    }
}

