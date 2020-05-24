package com.smtboy.news.controller.backend;


import com.smtboy.news.common.Const;
import com.smtboy.news.common.ServerResponse;
import com.smtboy.news.service.INewsProgramService;
import com.smtboy.news.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/newsProgram/")
public class NewsProgramController {


    @Autowired
    private INewsProgramService iNewsProgramService;

    @GetMapping("getAllNewsProgram")
    public ServerResponse getAllNewsProgram(
                                     @RequestParam(value="pageNum",defaultValue = "1",required = false) int pageNum,
                                     @RequestParam(value="pageSize",defaultValue = "10",required = false) int pageSize){

        return iNewsProgramService.getAllNewsProgram(pageNum, pageSize);
    }

    @PutMapping("putOneNewsProgram/{id}/{name}")
    public ServerResponse putOneNewsProgram(HttpSession session, @PathVariable int id,@PathVariable String name){

        return iNewsProgramService.putOneNewsProgram(id, name);
    }

    @DeleteMapping("deleteOneNewsProgram/{id}")
    public ServerResponse deleteOneNewsProgram(HttpSession session,@PathVariable int id){

        return iNewsProgramService.deleteOneNewsProgram(id);
    }

    @PostMapping("postOneNewsProgram")
    public ServerResponse postOneNewsProgram(HttpSession session,String name){

        return iNewsProgramService.postOneNewsProgram(name);
    }

}
