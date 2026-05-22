package com.example.demo.team10;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Team10Aspect {
	@Around("execution(* com.example.demo.team10..*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {

        String className  = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        Object[] args     = pjp.getArgs();

        System.out.println("=== [開始] " + className + "." + methodName + " ===");
        System.out.println("  引数: " + Arrays.toString(args));

        try {
            Object result = pjp.proceed();
            System.out.println("  戻り値: " + result);
            System.out.println("=== [終了] " + className + "." + methodName + " ===");
            return result;

        } catch (Throwable e) {
        	System.out.println("  例外発生: " + e.getClass().getSimpleName());
            System.out.println("  メッセージ: " + e.getMessage());
            throw e;
        }
    }
}