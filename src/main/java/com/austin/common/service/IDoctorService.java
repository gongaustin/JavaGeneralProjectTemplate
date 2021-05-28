package com.austin.common.service;

import com.austin.common.entity.Doctor;
import com.austin.common.entity.vo.DoctorVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
public interface IDoctorService extends IService<Doctor> {

    Page<DoctorVo> selectVoPage(Page page,QueryWrapper ew);

}
