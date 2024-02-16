package org.example.component.aspect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.cache.Cache;


public class CacheAcpect {
    static final Logger logger = LogManager.getLogger(CacheAcpect.class);
    private Cache<Object, String> cache = CacheBuilder.newBuilder().build();
    @Around("@annotation(annotation.Cache)")
    public String cacheCall(ProseedingJoinPoint jp) throws Throwable{
        Object arg = jp.getArgs()[0];
        String result = null;
        if(arg !=null){
            result = cache.getIfPresent(arg);
            if(result!=null){
                logger.info("value loaded from cache: "+result);
                return result;
            }
            result = (String) jp.proceed();
            cache.put(arg, result);
        }
        return result;
    }
}
