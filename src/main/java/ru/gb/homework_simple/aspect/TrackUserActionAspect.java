package ru.gb.homework_simple.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Log
public class TrackUserActionAspect {
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void logMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        log.info("Метод: " + method.getName() + "\n"
        + "Параметры: " + Arrays.toString(joinPoint.getArgs()) + "\n---------------------");
    }
}
