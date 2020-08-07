package com.javakc.cms.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class ChapterTest {
    /** 主键 */
    @Id
    @GeneratedValue
    private Integer id ;
    /** 章节名称 */
    private String chapterName ;
    /** 章节序号 */
    private Integer chapterSort ;
    /** 章节状态 */
    private Integer chapterStatus ;
    /** 更新时间 */
    private Date updateTime ;
    /** 外键 */
    private Book book;
}
