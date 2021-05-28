package com.austin.common.controller;


import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.entity.Doctor;
import com.austin.common.entity.vo.DoctorVo;
import com.austin.common.service.IDoctorService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/doctor")
@Api("医生前端控制器")
public class DoctorController {


    @Autowired
    private IDoctorService service;

    //分页查询
    @ApiOperation(value = "查询医生(分页、ID、模糊)", notes = "查询医生(分页、ID、模糊)")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "isDelete", value = "删除标识符", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = false, dataType = "String"),
            }
            )
    @GetMapping("/list")
    private Result getDoctorByPage(@RequestParam(defaultValue = "1") Integer current,@RequestParam(defaultValue = "10") Integer size, String keyword, Integer isDelete,String id) {
        Page<DoctorVo> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<DoctorVo> ew = new QueryWrapper();
        if (StringUtils.isNotBlank(keyword)) {
            ew.and(wrapper -> wrapper
                    .like("competent", keyword).or()
                    .like("name", keyword).or()
                    .like("title", keyword).or()
                    .like("special_talent", keyword).or()
                    .like("dept_name",keyword));
        }
        if (null != isDelete) {
            ew.eq("is_delete", isDelete);
        }
        if(StringUtils.isNotBlank(id)){
            ew.eq("id",id);
        }
        ew.orderByDesc("ctime");
        page = service.selectVoPage(page, ew);
        return Result.success(page);
    }


    //ID单查
    @ApiOperation(value = "ID查询医生", notes = "ID查询医生")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "查询ID", required = true, dataType = "String"),})
    @GetMapping(value = "/selectById", params = {"id"})
    private Result getDoctorByID(@NotBlank String id) {
        Doctor dr = this.service.getById(id);
        return Result.success(dr);
    }

    //ID逻辑删除

    @ApiOperation(value = "新增医生", notes = "新增医生")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "name", value = "姓名", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "deptId", value = "科室ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "competent", value = "职称", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "title", value = "职务", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "specialTalent", value = "专长", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "visitTime", value = "出诊时间", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "contact", value = "联系方式", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "description", value = "简介", required = false, dataType = "String"),
            }
    )
    @PostMapping(value = "/add", params = {"name","type","content"})
    private Result deleteLogicById(@NotNull Doctor doctor) {
        boolean b = this.service.save(doctor);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

    @ApiOperation(value = "修改医生信息、分配科室", notes = "修改医生信息、分配科室")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "医生ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "name", value = "姓名", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "deptId", value = "科室ID", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "competent", value = "职称", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "title", value = "职务", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "specialTalent", value = "专长", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "visitTime", value = "出诊时间", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "contact", value = "联系方式", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "description", value = "简介", required = false, dataType = "String"),
            }
    )
    @PostMapping(value = "/update", params = {"id"})
    private Result updateById(@NotNull Doctor doctor) {
        boolean b = this.service.save(doctor);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }
    //ID逻辑删除


    //ID逻辑删除
    @ApiOperation(value = "删除医生(逻辑删除)", notes = "删除医生(逻辑删除)")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "医生ID", required = true, dataType = "String"),})
    @PostMapping(value = "/deleteLogicById", params = {"id"})
    private Result deleteLogicById(@NotBlank String id) {
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setIsDelete(1);
        boolean b = this.service.updateById(doctor);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }


    //ID物理删除
    @ApiOperation(value = "删除医生(物理删除)", notes = "删除医生(物理删除)")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "科室ID", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/deletePhysicsById", params = {"id"})
    private Result deletePhysicsById(@NotBlank String id) {
        boolean b = this.service.removeById(id);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }



}

