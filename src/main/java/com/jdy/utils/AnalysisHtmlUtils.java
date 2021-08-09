package com.jdy.utils;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName AnalysisHtmlUtils
 * @Description 解析html工具类
 * @Author zhanglishen
 * @Date 2021/8/9 13:46
 **/
public class AnalysisHtmlUtils {

    public static String analysisResult(String result,String url){
        String param = null;
        try {
            Map<String,String> interfaceNamesMap = new HashMap<>(); //接口及接口名称
            Map<String,String> paramsMap = new HashMap<>(); //反参内容
            //String message = result.split("message")[0];
            Document document = Jsoup.parse(result);
            Elements tables = document.getElementsByTag("table");
            Elements interfaceNames = tables.get(0).children();
            for (Element interfaceName : interfaceNames) {
                Elements elements = interfaceName.select("tr");
                for (Element element : elements) {
                    String td = element.text();
                    //System.err.println("td = " + td);
                    String[] s = td.split(" ");
                    if (s[2].contains("&")){
                        String[] split = s[2].split("&");
                        interfaceNamesMap.put(split[0],s[0]);
                    }else{
                        interfaceNamesMap.put(s[2],s[0]);
                    }

                }
            }
            Elements paramsElements = tables.get(1).select("tbody");
            for (Element paramsElement : paramsElements) {
                Elements paramsTd = paramsElement.select("tr");
                //System.out.println("paramsTd.get(0).text() = " + paramsTd.get(0).text());
                for(int i=0;i < paramsTd.size();i++){
                    Elements td = paramsTd.get(i).select("td");
                    for (Element element : td) {
                        //System.err.println("element = " + element);
                    }
                }
            }

//            Set<String> strings = interfaceNamesMap.keySet();
//            for (String string : strings) {
//                System.out.println("string = " + string + "  ------- value =  " + interfaceNamesMap.get(string));
//            }

            if (interfaceNamesMap.containsKey(url)){
                String interfaceName = interfaceNamesMap.get(url);
                param = paramsMap.get(interfaceName);
            }
//            return param;
//        if (interfaceNamesMap != null && interfaceNamesMap.size() > 0 && paramsMap != null && paramsMap.size() > 0){
//            Set<String> interfaceNameKeys = interfaceNamesMap.keySet();
//            Set<String> paramsKeys = paramsMap.keySet();
//            for (String interfaceNameKey : interfaceNameKeys) {
//                for (String paramsKey : paramsKeys) {
//                    if (interfaceNamesMap.get(interfaceNameKey) == paramsKey){
//                        param = paramsMap.get(paramsKey);
//                    }
//                }
//            }
//        }

//        Elements tableContent = document.getElementsByClass("confluenceTable");
//        if (tableContent != null && tableContent.size() > 0){
//            Elements elements = tableContent.get(0).select("tbody>tr").select(".confluenceTd");
//            System.out.println("elements = " + elements);
//            if (elements != null && elements.size() > 0){
//                for (Element element : elements) {
//                    String text = element.text();
//                }
//            }
//
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
