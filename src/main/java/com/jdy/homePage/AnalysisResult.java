package com.jdy.homePage;

import com.jdy.utils.AnalysisHtmlUtils;
import com.jdy.utils.HttpClientUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @ClassName AnalysisResult
 * @Description 解析反参
 * @Author zhanglishen
 * @Date 2021/8/9 13:51
 **/
public class AnalysisResult {
    public static void main(String[] args) {
        String data = "";
        //String url = "http://admin.hoiyee.net/tounickszyh/szyh.php";
        String url = "http://admin.hoiyee.net/tounickszyh/szyh.php?t=1";
        try {
            //data = "?t=18";
        } catch (Exception e) {
            e.printStackTrace();
        }

        String message = HttpClientUtils.doGetOrPost(url,data,"GET");
        String result = AnalysisHtmlUtils.analysisResult(message, url);
        //System.out.println("result = " + result);
//        Document parse = Jsoup.parse(message);
//
//        Elements select = parse.select(".confluenceTable");
//        Elements q = select.select("tbody>tr");
//        for (Element element:q){
//            Elements children = element.children();
//            String name = children.get(0).text();
//            Element element1 = children.get(2);
//            String text = element1.text();
//            String substring = text.substring(text.indexOf("[") + 1);
//            System.out.println("substring = " + substring);
//            String message1 = substring.substring(substring.indexOf("Message"), substring.indexOf("["));
//            System.out.println(name+":"+message1.split("]")[1].split("=>")[1]);
//
//        }
    }
}
