package com.javakc.copyright.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaQuery {
    @ApiModelProperty(value = "版权名")
    private String copyright ;
    /** 公司 */
    @ApiModelProperty(value = "公司")
    private String company ;
    /** 备注名 */
    @ApiModelProperty(value = "备注名")
    private String noteName ;
}
