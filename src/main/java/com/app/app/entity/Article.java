package com.app.app.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Article {

    int id;
    int authorId;
    String title;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    Date createDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    Date updateDate;
    int viewCounts;
    int likeCounts;
    String summary;
    String bodyUrl;
    int categoryId;
}
