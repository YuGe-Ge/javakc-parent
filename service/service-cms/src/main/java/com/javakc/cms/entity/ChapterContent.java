package com.javakc.cms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name ="import_chaptercontent")
public class ChapterContent {
    /** 主键 */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "章节测试主键")
    private Integer id ;
    /** 章节名称 */
    @Column(name = "chapter_name")
    @ApiModelProperty(value = "章节名称")
    private String chapterName ;
    /** 章节序号 */
    @Column(name = "chapter_sort")
    @ApiModelProperty(value = "章节序号")
    private Integer chapterSort ;
    /** 章节状态 */
    @Column(name = "chapter_status")
    @ApiModelProperty(value = "章节状态")
    private Integer chapterStatus ;

    @Column(name = "chapter_content")
    @ApiModelProperty(value = "章节内容")
    private String chapterContent ;

    /** 外键 */
    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,//级联新增
                    CascadeType.MERGE,//级联修改
                    CascadeType.REMOVE//级联删除
            }
    )
    @JoinColumn(name = "bid",referencedColumnName="id")
    private Book book;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间",example = "2020-12-12 12:12:12")
    @Column(name = "gmt_create",nullable = false, updatable = false)
    private Date gmtCreate;


    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间",example = "2020-12-12 12:12:12")
    @Column(name = "gmt_modified",nullable = false, insertable = false)
    private Date gmtModified;

}
