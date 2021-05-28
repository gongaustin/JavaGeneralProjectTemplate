package com.austin.common.controller;


import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.core.constant.YiYuanConstant;
import com.austin.common.entity.Article;
import com.austin.common.service.IArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * <p>
 * 新闻资讯列表 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
/**
 * 还记得@Controller和@RestController的区别吗？
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 * 1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 例如：本来应该到login.html页面的，则其显示login.
 * 2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 3)如果需要返回json或者xml或者自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解
 *
 * @ResponseBody：
 * 作用：
 * 该注解用于将Controller方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后（如：json格式），写入到Response对象的body数据区。
 *
 * 使用时机：
 * 返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用
 * 当我们不需要讲数据封装,而是需要实现页面的跳转的时候,就将@responseBody去掉,然后最后返回跳转的页面名称就好.
 * */
@RestController
@RequestMapping("/article")
@Api("文章前端控制器")
@Validated
public class ArticleController {

    @Autowired
    private IArticleService service;

    //分页查询
    @ApiOperation(value = "查询文章(分页、ID、模糊)", notes = "查询文章(分页、ID、模糊)")
    /**
     * paramType = "query"必须加上，否则前端调试无法传参
     * */
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "isDelete", value = "删除标识符", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "keyword", value = "模糊查询关键字", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "moduleId", value = "所属模块ID", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = false, dataType = "String"),
            }
            )
    @GetMapping("/list")
    private Result getArticleByPage(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, String keyword, String moduleId, Integer isDelete,String id) {
        Page<Article> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<Article> ew = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)) {
            ew.and(wrapper -> wrapper.like("title", keyword).or().like("author", keyword));
        }
        if (StringUtils.isNotBlank(moduleId)) {
            ew.eq("module_id", moduleId);
        }
        if (null != isDelete) {
            ew.eq("is_delete", isDelete);
        }
        if(StringUtils.isNotBlank(id)){
            ew.eq("id",id);
        }
        ew.orderByDesc("ctime");
        page = this.service.page(page, ew);
        if(StringUtils.isBlank(id)){
            page.getRecords().forEach(e -> {
                e.setContent("");
            });
        }
        return Result.success(page);
    }

    //ID单查
//    @ApiOperation(value = "ID查询文章", notes = "ID查询文章")
//    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "查询ID", required = true, dataType = "String"),})
//    @GetMapping(value = "/selectById", params = {"id"})
    private Result getArticleByID(@NotBlank String id) {
        Article ae = this.service.getById(id);
        return Result.success(ae);
    }




    //ID逻辑删除
    @ApiOperation(value = "新增文章", notes = "新增文章")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "title", value = "标题", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "moduleId", value = "所属模块ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "content", value = "内容", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/add", params = {"title","content"})
    private Result deleteLogicById(@NotNull Article article) {
        article.setAuthor(YiYuanConstant.HOSPITAL_NAME);
        boolean b = this.service.save(article);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }


    @ApiOperation(value = "修改文章", notes = "修改文章")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "文章ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "title", value = "标题", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "moduleId", value = "所属模块ID", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "content", value = "内容", required = false, dataType = "String"),
            }
    )
    @PostMapping(value = "/update", params = {"id"})
    private Result updateById(@NotNull Article article) {
        boolean b = this.service.save(article);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }
    //ID逻辑删除


    //ID逻辑删除
    @ApiOperation(value = "删除文章(逻辑删除)", notes = "删除文章(逻辑删除)")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "文章ID", required = true, dataType = "String"),})
    @PostMapping(value = "/deleteLogicById", params = {"id"})
    private Result deleteLogicById(@NotBlank String id) {
        Article article = new Article();
        article.setId(id);
        article.setIsDelete(1);
        boolean b = this.service.updateById(article);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }


    //ID物理删除
    @ApiOperation(value = "删除文章(物理删除)", notes = "删除文章(物理删除)")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "文章ID", required = true, dataType = "String"),
            }
            )
    @PostMapping(value = "/deletePhysicsById", params = {"id"})
    private Result deletePhysicsById(@NotBlank String id) {
        boolean b = this.service.removeById(id);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

}

