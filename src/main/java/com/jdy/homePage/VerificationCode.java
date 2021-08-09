package com.jdy.homePage;

import com.jdy.utils.HttpClientUtils;

/**
 * @ClassName VerificationCode
 * @Description 验证码
 * @Author zhanglishen
 * @Date 2021/8/8 17:32
 **/
public class VerificationCode {

    public static void main(String[] args) {
        String pathUrl =  "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
        String params = "?tel=17631089214&output=json&callback=querycallback";
        String result = HttpClientUtils.doGet(pathUrl,params);
        System.out.println("result = " + result);

    }
}
