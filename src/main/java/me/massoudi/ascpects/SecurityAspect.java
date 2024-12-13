package me.massoudi.ascpects;

import me.massoudi.security.SecurityContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class SecurityAspect {

    @Before("@annotation(SecuredBy)")
    public void checkSecurity(org.aspectj.lang.JoinPoint joinPoint) throws SecurityException {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        SecuredBy securedBy = method.getAnnotation(SecuredBy.class);

        if (securedBy != null) {
            String[] requiredRoles = securedBy.roles();

            boolean authorized = false;
            for (String role : requiredRoles) {
                if (SecurityContext.hasRole(role)) {
                    authorized = true;
                    break;
                }
            }

            if (!authorized) {
                throw new SecurityException("Access denied: User does not have required roles.");
            }
        }
    }
}
