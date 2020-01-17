package po;

/**
 * Created by HUIYE on 2020/1/9.
 */
public class TextMessage extends  Message {
    private String Content;
    private String MsgId;
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
