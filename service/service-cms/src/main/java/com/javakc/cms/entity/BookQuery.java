package com.javakc.cms.entity;

import lombok.Data;

@Data
public class BookQuery {
    private String cpId;
    private String bookName;
    private String author;
    private Integer serialize;
    private Integer status;
    private Integer original;
    private String firstSort;
    private String secondSort;
    private Integer free;
}
