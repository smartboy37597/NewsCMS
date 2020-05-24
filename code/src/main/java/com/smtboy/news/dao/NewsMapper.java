package com.smtboy.news.dao;

import com.smtboy.news.pojo.News;
import com.smtboy.news.pojo.User;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> selectAllNews();
}