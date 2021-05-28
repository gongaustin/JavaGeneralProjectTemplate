package com.austin.common.service.impl;

import com.austin.common.entity.Dept;
import com.austin.common.mapper.DeptMapper;
import com.austin.common.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 科室 服务实现类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
