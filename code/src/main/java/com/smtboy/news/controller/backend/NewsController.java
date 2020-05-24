package com.smtboy.news.controller.backend;


import com.smtboy.news.common.ServerResponse;
import com.smtboy.news.request.PostNewsMessageVo;
import com.smtboy.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author doyledai
 */
@RestController
@RequestMapping("/news/")
public class NewsController {

    @Autowired
    private INewsService iNewsService;

    @GetMapping("getAllNews")
    public ServerResponse getAllNews(@RequestParam(value="pageNum",defaultValue = "1",required = false) int pageNum,
                                     @RequestParam(value="pageSize",defaultValue = "10",required = false) int pageSize){
        return iNewsService.getAllNews(pageNum, pageSize);
    }

    @GetMapping("getOneNews/{newsId}")
    public ServerResponse getOneNews(@PathVariable int newsId){
        return iNewsService.getOneNews(newsId);
    }

    @PutMapping("putOneNews")
    public ServerResponse putOneNews( PostNewsMessageVo postNewsMessageVo){
        return iNewsService.putOneNews(postNewsMessageVo);
    }

    @DeleteMapping("deleteOneNews/{newsId}")
    public ServerResponse deleteOneNews(@PathVariable int newsId){
        return iNewsService.deleteOneNews(newsId);
    }

    @PostMapping("postOneNews")
    public ServerResponse postOneNews(PostNewsMessageVo postNewsMessageVo){
        return iNewsService.postOneNews(postNewsMessageVo);
    }

    @PutMapping("operateOneNews/{newsId}/{type}")
    public ServerResponse operateOneNews(@PathVariable int newsId,@PathVariable String type){
        return iNewsService.operateOneNews(newsId, type);
    }
}
