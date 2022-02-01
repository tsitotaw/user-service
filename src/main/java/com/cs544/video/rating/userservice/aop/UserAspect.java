package com.cs544.video.rating.userservice.aop;

import com.cs544.video.rating.userservice.controller.UserController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Component
@Aspect
public class UserAspect {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(UserAspect.class);

    @AfterThrowing(pointcut = "execution(* com.cs544.video.rating.userservice.controller.*.*(..))", throwing="ex")
    public void logWhenControllerExceptionThrown(JoinPoint jp, Exception ex) throws Exception{
        this.logger.info("the following Exception is thrown - " + ex.getClass().getName());
    }

    @Around("execution(* getUserRatingByIdWith*(..))")
    public Object measureInterprocessSystemCallOnVideoMS(ProceedingJoinPoint jp) throws Throwable{
        StopWatch sw = new StopWatch();
        Object retVal = null;
        String methodName = jp.getSignature().getName();
        sw.start();
        try {
            retVal = jp.proceed();
        }catch(Throwable e){
            // do nothing
        }
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();

        this.logger.info("Time to execute the RPC " + methodName + " = " +totalTime);
        return retVal;
    }
}
