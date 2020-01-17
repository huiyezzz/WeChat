package utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import po.AccessToken;

import java.io.IOException;

/**
 * Created by HUIYE on 2020/1/16.
 */
public class WeChatRequestUtils {
    private static final String APPID="wxafbfd3ca44294ca1";
    private static final String APPSECRET="ef6149e3a3a4908fd94f6faef7cc59b6";
    private static final String GET_ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static JSONObject doGet(String url){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);//创建请求
        JSONObject jsonObject=null;
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);//执行请求获取响应
            HttpEntity entity = httpResponse.getEntity();//获取响应内容
            if(entity!=null){
                String s = EntityUtils.toString(entity,"UTF-8");//将entity转换为字符串
                jsonObject = JSONObject.fromObject(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONObject dopost(String url,String outStr){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);//创建请求
        JSONObject jsonObject=null;
        try {
            httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);//执行请求获取响应
            HttpEntity entity = httpResponse.getEntity();//获取响应内容
            if(entity!=null){
                String s = EntityUtils.toString(entity,"UTF-8");//将entity转换为字符串
                jsonObject = JSONObject.fromObject(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static AccessToken getAccessToken(){
        AccessToken accessToken = new AccessToken();
        String url = GET_ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        JSONObject jsonObject = doGet(url);
        System.out.println(jsonObject.toString());
        accessToken.setAccess_token(jsonObject.getString("access_token"));
        accessToken.setExpires_in( jsonObject.getInt("expires_in"));
        return accessToken;
    }

    @Test
    public void test(){
        AccessToken accessToken = WeChatRequestUtils.getAccessToken();
        System.out.println(accessToken);
    }
}
