package com.austin.common.service.impl;

import com.austin.common.entity.Module;
import com.austin.common.entity.vo.ModuleVo;
import com.austin.common.mapper.ModuleMapper;
import com.austin.common.service.IModuleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * <p>
 * 模块管理 服务实现类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-05-14
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

    @Override
    public List<ModuleVo> selectVoList(QueryWrapper<Module> ew) {

        List<Module> modules = this.baseMapper.selectList(ew);
        List<ModuleVo> moduleVos = Lists.newArrayList();
        modules.forEach(e->{
            ModuleVo ve = new ModuleVo();
            try {
                //不能想当然强转
                BeanUtils.copyProperties(ve,e);
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            moduleVos.add(ve);
        });
        return moduleVos;
    }
}
