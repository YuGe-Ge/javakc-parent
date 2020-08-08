package com.javakc.cms.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ChapterQuery {
    private String chapterName;
    private Integer chapterStatus;
    private Date startTime;
    private Date endTime;
}
