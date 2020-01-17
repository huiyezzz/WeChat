package utils;

import po.Item;
import po.NewsMessage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by HUIYE on 2020/1/15.
 */
public class MessageCreator {
    public static NewsMessage createNewMessage(String ToUserName,String FromUserName){
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setToUserName(FromUserName);
        newsMessage.setFromUserName(ToUserName);
        newsMessage.setMsgType("news");
        newsMessage.setCreateTime(new Date().toString());
        ArrayList<Item> articles = new ArrayList<>();
        Item item = new Item();
        item.setTitle("百度一下，你就知道！");
        item.setDescription("全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求。百度超过千亿的中文网页数据库，可以瞬间找到相关的搜索结果。");
        item.setPicUrl("http://8d272584.ngrok.io/image/wx1.png");
        item.setUrl("www.baidu.com");
        articles.add(item);
        newsMessage.setArticleCount(articles.size());
        newsMessage.setArticles(articles);
        return  newsMessage;
    }
}
