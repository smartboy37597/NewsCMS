package com.smtboy.news.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostNewsMessageVo {


    private Integer id;

    private Integer pId;

    private Integer userId;

    private String title;

    private String content;

    private String type;




}
