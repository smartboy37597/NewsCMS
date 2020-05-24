package com.smtboy.news.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smtboy.news.common.ServerResponse;
import com.smtboy.news.dao.NewsMapper;
import com.smtboy.news.dao.NewsProgramMapper;
import com.smtboy.news.pojo.News;
import com.smtboy.news.pojo.NewsProgram;
import com.smtboy.news.request.PostNewsMessageVo;
import com.smtboy.news.service.INewsProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iNewsProgramService")
public class NewsProgramServiceImpl implements INewsProgramService {

    @Autowired
    private NewsProgramMapper newsProgramMapper;

    /**
     * 查询新闻栏目列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getAllNewsProgram(int pageNum, int pageSize){
        //startpage
        PageHelper.startPage(pageNum, pageSize);
        List<NewsProgram> newsPrograms = newsProgramMapper.selectAllNewsProgram();
        PageInfo pageInfo = new PageInfo(newsPrograms);
        pageInfo.setList(newsPrograms);
        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 修改一个新闻栏目
     * @param id
     * @param name
     * @return
     */
    @Override
    public ServerResponse putOneNewsProgram(int id,String name ){
        NewsProgram newsProgram = new NewsProgram();
        newsProgram.setId(id);
        newsProgram.setName(name);
        int resultCount = newsProgramMapper.updateByPrimaryKeySelective(newsProgram);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");

    }

    /**
     * 删除一个新闻栏目
     * @param id
     * @return
     */
    @Override
    public ServerResponse deleteOneNewsProgram(int id){
        int resultCount = newsProgramMapper.deleteByPrimaryKey(id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }

    /**
     * 创建一个新闻栏目
     * @param name
     * @return
     */
    @Override
    public ServerResponse postOneNewsProgram(String name ){
        NewsProgram newsProgram = new NewsProgram();
        newsProgram.setName(name);
        int resultCount = newsProgramMapper.insert(newsProgram);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }


}
