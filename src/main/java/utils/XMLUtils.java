package utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import po.Item;
import po.NewsMessage;
import po.TextMessage;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HUIYE on 2020/1/9.
 */
public class XMLUtils {
    public static HashMap<String, String> xml2Map(HttpServletRequest request) throws IOException, DocumentException {
        ServletInputStream inputStream = request.getInputStream();
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(inputStream);
        Element rootElement = doc.getRootElement();
        List<Element> elements = rootElement.elements();
        HashMap<String, String> map = new HashMap<>();
        for (Element element : elements) {
            map.put(element.getName(),element.getText());
        }
        inputStream.close();
        return map;
    }
    public static String textMessageToXML(TextMessage textMessage){
        XStream xStream = new XStream();
        xStream.alias("xml",textMessage.getClass());
        String message = xStream.toXML(textMessage);
        return message;
    }
    public static String newsMessageToXML(NewsMessage newsMessage){
        XStream xStream = new XStream();
        xStream.alias("xml",newsMessage.getClass());
        xStream.alias("item", Item.class);
        String message = xStream.toXML(newsMessage);
        return message;
    }
}
