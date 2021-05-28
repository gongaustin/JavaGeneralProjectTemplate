package com.austin.common.controller;

import com.austin.common.core.annotation.MyLog;
import com.austin.common.core.bean.Result;
import com.austin.common.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:前端控制器
 * @Author: GongJun
 * @Date: Created in 16:56 2021/1/18
 */
@RestController
@RequestMapping("/")
@Api("测试控制器[仅供测试]")
public class TestController {
    @Autowired
    ITestService service;


    @GetMapping("")
    public Result defaultMethod() {
        return Result.success("this is ok");
    }

    @ApiOperation(value = "这真的只是一个测试方法", notes = "他说的对")
    @ApiImplicitParams({@ApiImplicitParam(name = "s", value = "请传入一个字符串", required = true, dataType = "String")})
    @MyLog("测试")
    @GetMapping("/test")
    public Result test(String s) {
        String data = this.service.getMessage(s);
        return Result.success(data);
    }
}
