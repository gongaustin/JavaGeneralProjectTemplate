package com.austin.common.controller;

import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.entity.Module;
import com.austin.common.entity.vo.ModuleVo;
import com.austin.common.service.IModuleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:模块管理
 * @Author: GongJun
 * @Date: Created in 14:38 2021/5/6
 */
@RestController
@RequestMapping("/module")
@Api("模块前端控制器")
public class ModuleController {


    @Autowired
    private IModuleService service;

    //分页查询
    @ApiOperation(value = "查询子模块", notes = "查询子模块")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "moduleName", value = "父模块名称", required = false, dataType = "String"), @ApiImplicitParam(paramType = "query", name = "parentId", value = "父模块ID", required = false, dataType = "String"),})
    @GetMapping("/selectByParent")
    private Result getModuleByList(String moduleName, String parentId) {

        if (StringUtils.isAllBlank(moduleName, parentId)) return Result.message(CodeMsg.PARAMETER_ERROR);
        QueryWrapper<Module> ew = new QueryWrapper();
        if (StringUtils.isNotBlank(moduleName)) {
            ew.eq("module_name", moduleName);
            ew.eq("level", 1);
            Module parentModule = this.service.getOne(ew);
            if (parentModule != null) {
                ew.clear();
                ew.eq("parent_id", parentModule.getId());
                ew.eq("level", 2);
                ew.orderByAsc("priority"); //排序
                List<Module> list = this.service.list(ew);
                return Result.success(list);
            }
        }

        if (StringUtils.isNotBlank(parentId)) {
            ew.clear();
            ew.eq("parent_id", parentId);
            ew.eq("level", 2);
            ew.orderByAsc("priority"); //排序
            List<Module> list = this.service.list(ew);
            return Result.success(list);
        }

        return null;

    }


    //ID单查
    @ApiOperation(value = "ID查询模块", notes = "ID查询模块")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "查询ID", required = true, dataType = "String"),})
    @GetMapping(value = "/selectById", params = {"id"})
    private Result getModuleByID(@NotBlank String id) {
        Module me = this.service.getById(id);
        return Result.success(me);
    }

    @ApiOperation(value = "添加二级模块", notes = "添加二级模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "parentModuleName", value = "父模块名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "moduleName", value = "模块名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "priority", value = "排序规则", required = false, dataType = "int"),
    })
    @GetMapping(value = "/addModule")
    private Result getModuleByID(@NotBlank String parentModuleName,@NotNull Module module) {
        QueryWrapper<Module> ew = new QueryWrapper<>();
        ew.eq("module_name",parentModuleName);
        ew.eq("level",1);
        Module parentModule = this.service.getOne(ew);
        if(parentModule == null) return Result.message(CodeMsg.OPERATE_FAIL);
        module.setParentId(parentModule.getId());
        module.setLevel(2);
        boolean b = this.service.save(module);
        if (b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }


    //修改

    @ApiOperation(value = "修改模块信息", notes = "修改模块信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "模块ID", required = true, dataType = "String"),})
    @PostMapping(value = "/update", params = {"id"})
    private Result updateById(@NotNull Module module) {
        boolean b = this.service.updateById(module);
        if (b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }
    //ID逻辑删除


    //ID物理删除
    @ApiOperation(value = "删除模块(物理删除)", notes = "删除模块(物理删除)")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "模块ID", required = true, dataType = "String"),})
    @PostMapping(value = "/deletePhysicsById", params = {"id"})
    private Result deletePhysicsById(@NotBlank String id) {
        Module module = this.service.getById(id);
        if (module.getLevel() == 1) return Result.message(CodeMsg.FORBID_ACTION);
        boolean b = this.service.removeById(id);
        if (b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

    //全部查出模块(没多少，不用搞太复杂)
    @ApiOperation(value = "全部查出模块", notes = "全部查出模块")
    @GetMapping("/selectAll")
    private Result selectAll(){
        QueryWrapper<Module> ew = new QueryWrapper();
        ew.orderByAsc("priority");
        List<ModuleVo> modules = this.service.selectVoList(ew);
        List<ModuleVo> parentVos = modules.stream().filter(e->e.getLevel() == 1).collect(Collectors.toList());
        for (int i = 0; i < parentVos.size(); i++) {
            String parentId = parentVos.get(i).getId();
            List<ModuleVo> sonVos = modules.stream().filter(e->parentId.equals(e.getParentId())).collect(Collectors.toList());
            parentVos.get(i).setChildren(sonVos);
        }
        return Result.success(parentVos);
    }

}
