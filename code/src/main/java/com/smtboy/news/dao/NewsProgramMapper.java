package com.smtboy.news.dao;

import com.smtboy.news.pojo.NewsProgram;

import java.util.List;

public interface NewsProgramMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsProgram record);

    int insertSelective(NewsProgram record);

    NewsProgram selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsProgram record);

    int updateByPrimaryKey(NewsProgram record);

    List<NewsProgram> selectAllNewsProgram();
}