package com.austin.common.mapper;

import com.austin.common.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 新闻资讯列表 Mapper 接口
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
