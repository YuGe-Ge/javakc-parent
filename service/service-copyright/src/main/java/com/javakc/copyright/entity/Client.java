package com.javakc.copyright.entity;

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
@Table(name ="import_client")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "generator_uuid")
    @GenericGenerator(name = "generator_uuid", strategy = "uuid")
    @ApiModelProperty(value = "书籍主键,采用hibernate的uuid生成32位字符串")
    private String id ;

    /** 姓名 */
    @Column(name = "name")
    @ApiModelProperty(value = "姓名")
    private String name ;
    /** 性别 */
    @Column(name = "sex")
    @ApiModelProperty(value = "性别")
    private Integer sex ;
    /** 出生日期 */
    @Column(name = "birthday")
    @ApiModelProperty(value = "出生日期",example = "2020-12-12 12:12:12")
    private Date birthday ;
    /** 职务 */
    @Column(name = "level")
    @ApiModelProperty(value = "职级")
    private Integer level ;
    /** 手机号 */
    @Column(name = "phone")
    @ApiModelProperty(value = "手机号")
    private String phone ;
    /** 座机号 */
    @Column(name = "seat_number")
    @ApiModelProperty(value = "座机号")
    private String seatNumber ;
    /** QQ */
    @Column(name = "qq")
    @ApiModelProperty(value = "QQ")
    private String qq ;
    /** 邮箱 */
    @Column(name = "email")
    @ApiModelProperty(value = "邮箱")
    private String email ;
    /** 公司地址 */
    @Column(name = "company_address")
    @ApiModelProperty(value = "公司地址")
    private String companyAddress ;
    /** 备注 */
    @Column(name = "note")
    @ApiModelProperty(value = "备注")
    private String note ;

    @Column(name = "mid")
    @ApiModelProperty(value = "外键")
    private Integer mid;

    /** 创建时间 */
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间",example = "2020-12-12 12:12:12")
    @Column(name = "gmt_create",nullable = false, updatable = false)
    private Date gmtCreate ;
    /** 更新时间 */
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间",example = "2020-12-12 12:12:12")
    @Column(name = "gmt_modified",nullable = false, insertable = false)
    private Date gmtModified ;



}
