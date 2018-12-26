package com.myself.spel.service;

import org.springframework.stereotype.Service;

/**
 * 类名称：TestServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月26日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String message) {
        return "Receive message: " + message;
    }
}
