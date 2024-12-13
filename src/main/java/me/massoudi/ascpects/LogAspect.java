package me.massoudi.ascpects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

//@Aspect
//public class LogAspect {
//
//    @Around("@annotation(me.massoudi.ascpects.Log)")
//    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Log logAnnotation = signature.getMethod().getAnnotation(Log.class);
//        String logMessage = logAnnotation.value();
//
//        if (!logMessage.isEmpty()) {
//            System.out.println(logMessage);
//        } else {
//            long startTime = System.currentTimeMillis();
//            Object result = joinPoint.proceed(); // Execute the annotated method
//            long endTime = System.currentTimeMillis();
//            long duration = endTime - startTime;
//            String methodName = joinPoint.getSignature().toShortString();
//            System.out.println("Method " + methodName + " executed in " + duration + " ms.");
//            return result;
//        }
//        return joinPoint.proceed(); // Execute the annotated method
//    }
//}
