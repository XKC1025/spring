package com.xkc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 日志切面类
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(* com.xkc.spring.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logOnStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "方法执行, 方法参数: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void logOnEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "方法结束执行, 方法参数: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("返回值：" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("异常:" + exception.getMessage());
    }

    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开启环绕通知...");
        Object proceed = joinPoint.proceed();
        System.out.println("结束环绕通知...");
        return proceed;
    }

}
