package com.austin.common.service;

import com.austin.common.entity.Module;
import com.austin.common.entity.vo.ModuleVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 模块管理 服务类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-05-14
 */
public interface IModuleService extends IService<Module> {

    List<ModuleVo> selectVoList(QueryWrapper<Module> ew);

}
