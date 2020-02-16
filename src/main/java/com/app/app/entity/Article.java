package com.app.app.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Article {

    Integer id;
    Integer authorId;
    String title;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    Date createDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    Date updateDate;
    Integer viewCounts;
    Integer likeCounts;
    String summary;
    String bodyUrl;
    Integer categoryId;
}
