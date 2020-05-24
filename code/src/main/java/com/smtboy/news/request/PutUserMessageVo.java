package com.smtboy.news.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PutUserMessageVo {

    private Integer id;

    private String name;

    private String mobile;

    private String mail;

    private String type;


}