package me.massoudi.ascpects;

import me.massoudi.utils.CacheManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CacheAspect {


    @Around("@annotation(Cachable)")
    public Object cacheMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = createCacheKey(joinPoint);

        if (CacheManager.isInCache(key)) {
            System.out.println("Valeur récupérée du cache pour la méthode : " + joinPoint.getSignature());
            return CacheManager.getFromCache(key);
        }

        Object result = joinPoint.proceed();
        CacheManager.addToCache(key, result);
        System.out.println("Valeur calculée et ajoutée au cache pour la méthode : " + joinPoint.getSignature());

        return result;
    }

    private String createCacheKey(ProceedingJoinPoint joinPoint) {
        StringBuilder keyBuilder = new StringBuilder(joinPoint.getSignature().toString());
        for (Object arg : joinPoint.getArgs()) {
            keyBuilder.append("-").append(arg.toString());
        }
        return keyBuilder.toString();
    }
}
