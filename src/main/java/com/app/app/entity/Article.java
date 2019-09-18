package com.app.app.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {

    int id;
    int authorId;
    String title;
    Date createDate;
    Date updateDate;
    int viewCounts;
    int likeCounts;
    String summary;
    String bodyUrl;
    int categoryId;
}
