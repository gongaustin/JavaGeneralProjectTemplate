package com.austin.common.mapper;

import com.austin.common.entity.Module;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 模块管理 Mapper 接口
 * </p>
 *
 * @author AustinGJ
 * @since 2021-05-14
 */
@Mapper
public interface ModuleMapper extends BaseMapper<Module> {

}
