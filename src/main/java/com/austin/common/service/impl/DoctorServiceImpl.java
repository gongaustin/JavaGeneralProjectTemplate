package com.austin.common.service.impl;

import com.austin.common.entity.Doctor;
import com.austin.common.entity.vo.DoctorVo;
import com.austin.common.mapper.DoctorMapper;
import com.austin.common.service.IDoctorService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

    @Override
    public Page<DoctorVo> selectVoPage(Page page,QueryWrapper ew) {
        return this.baseMapper.selectVoPage(page,ew);
    }
}
