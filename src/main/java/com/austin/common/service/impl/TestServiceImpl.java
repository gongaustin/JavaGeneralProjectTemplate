package com.austin.common.service.impl;

import com.austin.common.mapper.TestMapper;
import com.austin.common.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 16:57 2021/1/18
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Object> implements ITestService {
    @Override
    public String getMessage(String s) {
        return this.baseMapper.getMessage(s);
    }
}
