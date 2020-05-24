package com.smtboy.news.service;

import com.smtboy.news.common.ServerResponse;

public interface INewsProgramService {

    /**
     * 查询新闻栏目列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getAllNewsProgram(int pageNum, int pageSize);

    /**
     * 修改一个新闻栏目
     * @param id
     * @param name
     * @return
     */
    public ServerResponse putOneNewsProgram(int id,String name );

    /**
     * 删除一个新闻栏目
     * @param id
     * @return
     */
    public ServerResponse deleteOneNewsProgram(int id);

    /**
     * 创建一个新闻栏目
     * @param name
     * @return
     */
    public ServerResponse postOneNewsProgram(String name );


}
