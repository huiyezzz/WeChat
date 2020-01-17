package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by HUIYE on 2020/1/9.
 */
@Controller
public class WeChatValidate {
    private static final String TOKEN = "HUIYE";

    @GetMapping("/weChat")
    @ResponseBody
    public String weChatValidate(String signature, String timestamp, String nonce, String echostr) {
        System.out.println("signature:"+signature+",timestamp:"+timestamp+",nonce:"+nonce+",echostr:"+echostr);
        boolean b = checkWeChatRequest(signature, timestamp, nonce);
        if (b){
            return echostr;
        }
        return null;
    }

    public boolean checkWeChatRequest(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(arr);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i]);
        }
        String sha1 = getSha1(stringBuffer.toString());
        return signature.equals(sha1);
    }

    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }

}
