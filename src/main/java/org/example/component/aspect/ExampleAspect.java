package org.example.component.aspect;


import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class ExampleAspect {
    static final Logger logger = LogManager.getLogger(ExampleAspect.class);
    @Pointcut("execution(public * component.ExampleClass.methodOne(..))");
    public void callMethodOne(){
    }
    @Pointcut("execution(public * component.ExampleClass.methodTwo(..))");
    public void callMethodTwo(){
    }
    @Pointcut("execution(public * component.ExampleClass.methodThree(..))");
    public void callMethodThree(){
    }
    @Before("callMethodOne()")
    public void beforeCallMethodOne(Joinpoint jp){logger.info("run before advice");}
    @After("callMethodOne()")
    public void afterCallMethodOne(Joinpoint jp){logger.info("run before advice");}
    @Around("callMethodTwo")
    public String aroundCallMethodTwo(ProceedingJoinPoint jp)throws Throwable{
        logger.info("Run around advice");
        return "around advice";
    }
    @AfterReturning(poincut = "execution( public * component.ExampleClass.methodTwo(..))", returning = "returnValue)
    public void afterCallCatSad(Joinpoint jp, String returnValue){logger.info("run after returning advice");}
    @AfterReturning(poincut = "execution( public * component.ExampleClass.methodTwo(..))", returning = "returnValue)
    public void afterCallCatSick(Joinpoint jp, Exception exaption){logger.info("run after throwing advice");}