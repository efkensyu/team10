package com.example.demo.team10;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Team10Aspect {
	@Before("execution(* com.example.demo.team10.*.*.index(..))")
	public void beforeLog(JoinPoint jp) {
		System.out.println("[Before]indexメソッド開始：" + jp.getSignature());
		System.out.println("送ったデータ：" + Arrays.toString(jp.getArgs()));
	}
	
	@After("execution(* com.example.demo.team10.*.*.index(..))")
	public void afterLog(JoinPoint jp) {
		System.out.println("[After]indexメソッド開始：" + jp.getSignature());
	}
	
	@Around("execution(* com.example.demo.team10.*.*.index(..))")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable  {
		System.out.println("[Around]indexメソッド開始：" + jp.getSignature());
		Object result = jp.proceed(); //indexを実行してる
		//indexがkensyu5/Aop1_1をリターンしてる
		System.out.println("[Around]indexメソッド終了：" + jp.getSignature());
		
		return result;//ここでkensyu5/1_1のページを開いて元に戻る
		//return "kensyu5/Test";
	}
	
	@AfterReturning("execution(* com.example.demo.team10.*.index(..))")
	public void returningLog(JoinPoint jp) {
		System.out.println("[AfterReturning]indexメソッド正常終了：" + jp.getSignature());
	}
	
	@AfterThrowing("execution(* com.example.demo.team10.*.index(..))")
	public void throwingLog(JoinPoint jp) {
		System.out.println("[AfterThrowing]indexメソッド異常終了：" + jp.getSignature());
	}
}