package com.javakc.cms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name ="cms_book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "generator_uuid")
    @GenericGenerator(name = "generator_uuid", strategy = "uuid")
    @ApiModelProperty(value = "书籍主键,采用hibernate的uuid生成32位字符串")
    private String id;

    @Column(name = "cp_id")
    @ApiModelProperty(value = "版权方书籍编号")
    private String cpId;
    @Column(name = "book_name")
    private String bookName;

    @ApiModelProperty(value = "作者")
    @Column(name = "author")
    private String author;

    @ApiModelProperty(value = "一级分类")
    @Column(name = "first_sort")
    private String firstSort;

    @ApiModelProperty(value = "二级分类")
    @Column(name = "second_sort")
    private String secondSort;

    @ApiModelProperty(value = "是否连载")
    @Column(name = "is_serialize")
    private Integer serialize;

    @ApiModelProperty(value = "字数")
    @Column(name = "word_number")
    private Integer wordNumber;

    @ApiModelProperty(value = "状态")
    @Column(name = "is_status")
    private Integer status;

    @ApiModelProperty(value = "是否免费")
    @Column(name = "is_free")
    private Integer free;

    @ApiModelProperty(value = "授权开始时间",example = "2020-12-12 12:12:12")
    @Column(name = "start_time")
    private Date startTime;

    @ApiModelProperty(value = "授权结束时间",example = "2020-12-12 12:12:12")
    @Column(name = "end_time")
    private Date endTime;

    @ApiModelProperty(value = "是否原创")
    @Column(name = "is_original")
    private Integer original;

    @ApiModelProperty(value = "授权状态")
    @Column(name = "authorization_status")
    private Integer authorizationStatus;


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
