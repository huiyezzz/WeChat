package controller;

import org.dom4j.DocumentException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.MessageCreator;
import utils.XMLUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by HUIYE on 2020/1/9.
 */
@Controller
public class ReplyController {
    @PostMapping("/weChat")
    @ResponseBody
    public String Test(HttpServletRequest request) throws IOException, DocumentException {
        HashMap<String, String> requestParemeterHashMap = XMLUtils.xml2Map(request);
        String toUserName = requestParemeterHashMap.get("ToUserName");
        String fromUserName = requestParemeterHashMap.get("FromUserName");
        String createTime = requestParemeterHashMap.get("CreateTime");
        String msgType = requestParemeterHashMap.get("MsgType");
        String content = requestParemeterHashMap.get("Content");
        System.out.println(requestParemeterHashMap);
        if(msgType.equals("text")){
//            TextMessage textMessage = new TextMessage();
//            textMessage.setFromUserName(toUserName);
//            textMessage.setToUserName(fromUserName);
//            textMessage.setMsgType("text");
//            textMessage.setCreateTime(new Date().toString());
//            textMessage.setContent("您发送的消息是："+content);
//            return XMLUtils.textMessageToXML(textMessage);
            System.out.println(MessageCreator.createNewMessage(toUserName,fromUserName).toString());
            return XMLUtils.newsMessageToXML(MessageCreator.createNewMessage(toUserName,fromUserName));
        }
        return null;
    }



}
