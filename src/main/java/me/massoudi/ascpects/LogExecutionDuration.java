package me.massoudi.ascpects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LogExecutionDuration {

    @Around("@annotation(me.massoudi.ascpects.Log)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("Method " + methodName + " executed in " + duration + " ms.");
        return result;
    }
}
