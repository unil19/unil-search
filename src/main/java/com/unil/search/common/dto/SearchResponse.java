package com.unil.search.common.dto;

import lombok.Data;

/**
 * @author liuwh33
 * @date 2018/9/10 15:23
 * @desc
 */
@Data
public class SearchResponse<T> {

    private String code;
    private String msg;
    private T data;
    public SearchResponse(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public SearchResponse(){
        this.code ="0";
        this.msg = "hello world";
    }
}
