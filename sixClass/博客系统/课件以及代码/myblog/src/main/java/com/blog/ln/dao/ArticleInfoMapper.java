package com.blog.ln.dao;

import com.blog.ln.bean.ArticleInfo;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);
}