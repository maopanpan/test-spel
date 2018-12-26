package com.myself.spel.aop;

import java.lang.annotation.*;

/**
 * 类名称：Myself<br>
 * 类描述：<br>
 * 创建时间：2018年12月26日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Myself {
    String value() default "";
}
