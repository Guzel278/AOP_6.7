package org.example.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleClass {
    static final Logger logger = LogManager.getLogger(ExampleClass.class);
    public String methodOne(String param){
        logger.info("Execute methodOne");
        return "Hello " + param + "from methodOne";
    }
    public void methodTwo(){
        logger.info("Hellow world frpm methodTwo");
    }
    public void methodThree() {throw new RuntimeException("exeption from methodThree");}
}
