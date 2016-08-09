package com.andy.po;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspact {
	@Pointcut("execution(* com.andy.service.UserService.getSingleUser(..))")
	public void say() {
	}

	@Before(value = "say()")
	public void before() {
		System.out.println("切点之前调用");
	}

	@After(value = "say()")
	public void after() {
		System.out.println("切点之后调用");
	}
}
