package com.smtboy.news.service;

import com.smtboy.news.common.ServerResponse;
import com.smtboy.news.request.PostNewsMessageVo;

/**
 * @author doyledai
 */
public interface INewsService {

    /**
     * 查询所有新闻列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getAllNews(int pageNum, int pageSize);

    /**
     * 查询单个新闻内容
     * @param newsId
     * @return
     */
    public ServerResponse getOneNews(int newsId);

    /**
     * 修改单个新闻
     * @param postNewsMessageVo
     * @return
     */
    public ServerResponse putOneNews(PostNewsMessageVo postNewsMessageVo );

    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    public ServerResponse deleteOneNews(int newsId);

    /**
     * 创建新闻
     * @param postNewsMessageVo
     * @return
     */
    public ServerResponse postOneNews(PostNewsMessageVo postNewsMessageVo);

    /**
     * 操作新闻状态
     * @param newsId
     * @param type 0正常，1审核，2回收
     * @return
     */
    public ServerResponse operateOneNews(int newsId,String type);


}
