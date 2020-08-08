package com.javakc.cms.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ChapterTestQuery {
    private String chapterName;
    private Integer chapterStatus;
    private Date startTime;
    private Date endTime;
}
