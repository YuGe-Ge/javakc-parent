package com.javakc.copyright.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClQuery {

    /** 公司 */
    @ApiModelProperty(value = "版权名")
    private String copyright ;
    /** 备注名 */
    @ApiModelProperty(value = "姓名")
    private String name ;

}
