package com.javakc.servicebase.hanler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HctfException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "信息")
    private String msg;
}
