package com.myself.spel.controller;

import com.myself.spel.aop.Myself;
import com.myself.spel.service.TestService;
import com.myself.spel.vo.PersonVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：TestController<br>
 * 类描述：<br>
 * 创建时间：2018年12月26日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/sayHello")
    @Myself(value = "#idCard+#name")
    public String sayHello(String idCard, String name) {
        return testService.sayHello(idCard);
    }

    @PostMapping(value = "/sayHello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Myself(value = "#personVO.idCard+#personVO.name")
    public String sayHello(@RequestBody PersonVO personVO) {
        return testService.sayHello(personVO.getIdCard());
    }

}
