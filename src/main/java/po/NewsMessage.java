package po;

import java.util.List;

/**
 * Created by HUIYE on 2020/1/15.
 */
public class NewsMessage extends Message {
    private int ArticleCount;
    private List<Item> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Item> getArticles() {
        return Articles;
    }

    public void setArticles(List<Item> articles) {
        this.Articles = articles;
    }
}
