package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HUIYE on 2020/1/9.
 */
@Controller
public class HelloWorld {
    @RequestMapping("/hello")
    @ResponseBody
    public String Test(){
        return "你好 世界！";
    }

}
