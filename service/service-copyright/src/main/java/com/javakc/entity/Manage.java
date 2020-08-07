package com.javakc.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Manage {
    @Id
    @GeneratedValue
    private Integer id ;
    /** 外键 */
    private Integer mid ;
    /** 姓名 */
    private String name ;
    /** 性别 */
    private Integer sex ;
    /** 出生日期 */
    private Date birthday ;
    /** 职务 */
    private Integer level ;
    /** 手机号 */
    private String phone ;
    /** 座机号 */
    private String seatNumber ;
    /** QQ */
    private String qq ;
    /** 邮箱 */
    private String email ;
    /** 公司地址 */
    private String companyAddress ;
    /** 备注 */
    private String note ;
    /** 创建时间 */
    private Date gmtCreate ;
    /** 更新时间 */
    private Date gmtModified ;
}
