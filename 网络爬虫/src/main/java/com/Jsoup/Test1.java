package com.Jsoup;

/*import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.jsoup.nodes.Document;

import java.io.File;
import java.net.URL;
import java.util.Set;

public class Test1 {
    //解析URL
    @Test
    public void TestURL() throws Exception{
       Document doc= Jsoup.parse(new URL("http://www.itcast.cn"),1000);
         String title=doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }
    //解析字符串
    @Test
    public void TestString() throws  Exception{
      String Connect=  FileUtils.readFileToString(new File("C:\\Users\\ASUS\\Desktop\\test.html"),"utf8");
      Document doc=Jsoup.parse(Connect);
        String title=doc.getElementsByTag("title").first().text();
        System.out.println(title);

    }
    //解析文件
    @Test
    public void TestFile() throws  Exception{
        Document doc=Jsoup.parse(new File("C:\\Users\\ASUS\\Desktop\\test.html"),"utf8");
        String title=doc.getElementsByTag("title").first().text();
        System.out.println(title);

    }
    //使用dom 获取元素
    @Test
    public void TestDom() throws  Exception{
        Document document=Jsoup.parse(new File("C:\\Users\\ASUS\\Desktop\\test.html"),"utf8");
        //1.    根据id查询元素getElementById
        Element element = document.getElementById("city_bj");
        System.out.println(element.text());

       //2.  根据标签获取元素getElementsByTag
        element = document.getElementsByTag("span").first();
        System.out.println(element.text());

     //3.   根据class获取元素getElementsByClass
        element = document.getElementsByClass("s_name").last();
        System.out.println(element.text());

     //4.   根据属性获取元素getElementsByAttribute
        element = document.getElementsByAttribute("abc").first();
        System.out.println(element.text());
        element = document.getElementsByAttributeValue("class", "city_con").first();
        System.out.println(element.text());


    }
    //获区属性元素
    @Test
    public void testData() throws Exception{
        Document document=Jsoup.parse(new File("C:\\Users\\ASUS\\Desktop\\test.html"),"utf8");
        Element element=  document.getElementById("test");
        String str="";
        str=element.id();
        System.out.println(str);
        str=element.className();
        System.out.println(str);
       Set<String> classNames=element.classNames();
       for(String s: classNames){
           System.out.println(s);
       }
      str= element.attr("id");
        System.out.println(str);

    }
    //选择器的使用
    @Test
    public void testSelect() throws  Exception{
        Document document=Jsoup.parse(new File("C:\\Users\\ASUS\\Desktop\\test.html"),"utf8");
           Elements elements= document.select("span");
           for(Element e: elements){
               System.out.println(e.text());
           }
         Element el=  document.select("#ciyt_bj").first();
        System.out.println(el.text());
        Element element = document.select(".class_a").first();
        //[attribute]: 利用属性查找元素，比如：[abc]
       String str = document.select("[abc]").text();
        System.out.println(str);

    }
    //选择器的组合使用
    @Test
    public  void testSelect2() throws  Exception{
        Document document=Jsoup.parse(new File("C:\\Users\\ASUS\\Desktop\\test.html"),"utf8");
        //el#id: 元素+ID，比如： h3#city_bj
        String str = document.select("h3#city_bj").text();
        System.out.println(str);

//el.class: 元素+class，比如： li.class_a
        str = document.select("li.class_a").text();
        System.out.println(str);


//el[attr]: 元素+属性名，比如： span[abc]
        str = document.select("span[abc]").text();
        System.out.println(str);


//任意组合，比如：span[abc].s_name
        str = document.select("span[abc].s_name").text();
        System.out.println(str);


//ancestor child: 查找某个元素下子元素，比如：.city_con li 查找"city_con"下的所有li
        str = document.select(".city_con li").text();
        System.out.println(str);


//parent > child: 查找某个父元素下的直接子元素，
//比如：.city_con > ul > li 查找city_con第一级（直接子元素）的ul，再找所有ul下的第一级li
        str = document.select(".city_con > ul > li").text();
        System.out.println(str);


//parent > * 查找某个父元素下所有直接子元素.city_con
    }



}*/
