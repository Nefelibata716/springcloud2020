package com.gguoliang.springcloud.entities;

import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 9:20 上午
 * @Version 1.0
 */
@Data

public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    public CommonResult(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
