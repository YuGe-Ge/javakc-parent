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
@Table(name ="import_manage")
public class Manage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "书籍主键,采用hibernate的uuid生成32位字符串")
    private Integer id ;
    /** 版权 */
    @Column(name = "copyright")
    @ApiModelProperty(value = "版权名")
    private String copyright ;
    /** 公司 */
    @Column(name = "company")
    @ApiModelProperty(value = "公司")
    private String company ;
    /** 备注名 */
    @Column(name = "notename")
    @ApiModelProperty(value = "备注名")
    private String noteName ;
    /** 上线数量 */
    @Column(name = "online_number")
    @ApiModelProperty(value = "上线数量")
    private Integer onlineNumber ;
    /** 未上线数量 */
    @Column(name = "unline_number")
    @ApiModelProperty(value = "未上线数量")
    private Integer unlineNumber ;
    /** 即将过期数量 */
    @Column(name = "soon_number")
    @ApiModelProperty(value = "即将过期数量")
    private Integer soonNumber ;
    /** 合作状态 */
    @Column(name = "cooperation")
    @ApiModelProperty(value = "合作状态")
    private Integer cooperation ;
    /** 版权简介 */
    @Column(name = "introduce")
    @ApiModelProperty(value = "版权简介")
    private String introduce ;
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
    /** 外键 */
    @OneToMany(
                        cascade ={
                                CascadeType.PERSIST,//级联新增
                                CascadeType.MERGE,//级联修改
                                CascadeType.REMOVE//级联删除
                        },
            fetch = FetchType.EAGER//不采用延迟，直接查询
    )
    @JoinColumn(name = "mid",referencedColumnName = "id")
    @ApiModelProperty(value = "外键")
    private List<Client> clients ;
}
