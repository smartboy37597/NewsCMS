package com.smtboy.news.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMessageVo {

    private Integer id;

    private String name;

    private String mobile;

    private String mail;

    private String type;

    private Date createTime;

    private Date updateTime;

}
