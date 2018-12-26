package com.myself.spel.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 类名称：SpelAspect<br>
 * 类描述：<br>
 * 创建时间：2018年12月26日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@Aspect
@Component
public class SpelAspect {
    ExpressionParser parser = new SpelExpressionParser();
    LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Around("@annotation(myself)")
    public void handler(ProceedingJoinPoint joinPoint, Myself myself) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String value = myself.value();
        String[] param = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < param.length; i++) {
            context.setVariable(param[i], args[i]);
        }

        Expression expression = parser.parseExpression(value);
        System.out.println("#########:" + expression.getValue(context, String.class));

        joinPoint.proceed();
    }
}
