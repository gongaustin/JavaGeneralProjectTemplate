package com.austin.common.service.impl;

import com.austin.common.entity.Article;
import com.austin.common.mapper.ArticleMapper;
import com.austin.common.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 新闻资讯列表 服务实现类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
