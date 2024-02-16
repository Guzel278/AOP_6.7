package org.example.component.aspect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.App;

public class TraceAcpect {
    static final Logger logger = LogManager.getLogger(TraceAcpect.class);
    @Before("execution(component.*.*(..))")
    private void traceCall(JoinPoint jp){
        logger.info(jp.getSignature());
    }
}
