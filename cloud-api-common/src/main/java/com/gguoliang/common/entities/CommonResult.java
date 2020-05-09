package com.gguoliang.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 9:20 上午
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class CommonResult<T>  implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public CommonResult(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
