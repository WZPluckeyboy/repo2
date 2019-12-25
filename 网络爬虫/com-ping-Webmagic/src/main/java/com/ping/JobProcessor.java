package com.ping;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JobProcessor implements PageProcessor {
    @Override
    //解析页面
    public void process(Page page) {
        //解析数据放入
        page.putField("div",page.getHtml().css("div.mt h2").all());
        //获取链接
        page.addTargetRequests(page.getHtml().css("div#news_div ").links().regex(".*9$").all());

    }
    private  Site site=Site.me().setCharset("utf8").setTimeOut(1000).
            setRetrySleepTime(1000)//重试间隔时间
            .setSleepTime(3)//设置重试次数
            ;
    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
        Spider.create(new JobProcessor()).addUrl("https://www.jd.com/moreSubject.aspx").run();
        Spider.create(new JobProcessor()).addUrl("https://www.jd.com/moreSubject.aspx").addPipeline(new
                FilePipeline("C:\\Users\\ASUS\\Desktop\\Image")).thread(5).run();
    }
}
