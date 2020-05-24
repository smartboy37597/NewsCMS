package com.smtboy.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smtboy.news.common.ServerResponse;
import com.smtboy.news.dao.NewsMapper;
import com.smtboy.news.pojo.News;
import com.smtboy.news.pojo.User;
import com.smtboy.news.request.PostNewsMessageVo;
import com.smtboy.news.request.PutUserMessageVo;
import com.smtboy.news.service.INewsService;
import com.smtboy.news.vo.UserMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iNewsService")
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询所有新闻列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getAllNews(int pageNum, int pageSize){
        //startpage
        PageHelper.startPage(pageNum, pageSize);
        List<News> news = newsMapper.selectAllNews();
        PageInfo pageInfo = new PageInfo(news);
        pageInfo.setList(news);
        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 查询单个新闻内容
     * @param newsId
     * @return
     */
    @Override
    public ServerResponse getOneNews(int newsId){

        News news = newsMapper.selectByPrimaryKey(newsId);
        if (news == null) {
            return ServerResponse.createByErrorMessage("查询失败！");
        }

        return ServerResponse.createBySuccess(news);
    }

    /**
     * 修改单个新闻
     * @param postNewsMessageVo
     * @return
     */
    @Override
    public ServerResponse putOneNews(PostNewsMessageVo postNewsMessageVo ){

        News news = new News();
        news.setId(postNewsMessageVo.getId());
        if (!postNewsMessageVo.getContent().equals("") && postNewsMessageVo.getContent() != null) {
            news.setContent(postNewsMessageVo.getContent());
        }
        if (!postNewsMessageVo.getPId().equals("") && postNewsMessageVo.getPId() != null) {
            news.setpId(postNewsMessageVo.getPId());
        }
        if (!postNewsMessageVo.getTitle().equals("") && postNewsMessageVo.getTitle() != null) {
            news.setTitle(postNewsMessageVo.getTitle());
        }
        if (!postNewsMessageVo.getUserId().equals("") && postNewsMessageVo.getUserId() != null) {
            news.setUserId(postNewsMessageVo.getUserId());
        }
        if (!postNewsMessageVo.getType().equals("") && postNewsMessageVo.getType() != null) {
            news.setType(postNewsMessageVo.getType());
        }
        int resultCount = newsMapper.updateByPrimaryKeySelective(news);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");

    }

    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    @Override
    public ServerResponse deleteOneNews(int newsId){
        int resultCount = newsMapper.deleteByPrimaryKey(newsId);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }

    /**
     * 创建新闻
     * @param postNewsMessageVo
     * @return
     */
    @Override
    public ServerResponse postOneNews(PostNewsMessageVo postNewsMessageVo){
        News news = new News();
//        news.setId(postNewsMessageVo.getId());
        news.setContent(postNewsMessageVo.getContent());
        news.setpId(postNewsMessageVo.getPId());
        news.setReadCount(0);
        news.setTitle(postNewsMessageVo.getTitle());
        news.setUserId(postNewsMessageVo.getUserId());
        news.setType(postNewsMessageVo.getType());
        int resultCount = newsMapper.insert(news);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }

    /**
     * 操作新闻状态
     * @param newsId
     * @param type 0正常，1审核，2回收
     * @return
     */
    @Override
    public ServerResponse operateOneNews(int newsId, String type){
        if (!type.equals("0") && !type.equals("1") && !type.equals("3")) {
            return ServerResponse.createByErrorMessage("参数有误！");
        }
        News news = new News();
        news.setId(newsId);
        news.setType(type);
        int resultCount = newsMapper.updateByPrimaryKeySelective(news);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");

    }


}
