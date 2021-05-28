package com.austin.common.mapper;

import com.austin.common.entity.Doctor;
import com.austin.common.entity.vo.DoctorVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {

    Page<DoctorVo> selectVoPage(Page page,@Param("ew") QueryWrapper ew);

}
