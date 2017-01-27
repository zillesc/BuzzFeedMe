package ninja.zilles;

/**
 * Created by zilles on 1/26/17.
 * <p>
 * Representation of the JSON returned from:
 * https://newsapi.org/v1/articles?source=buzzfeed&sortBy=popular&apiKey=YOUR_API_KEY_HERE
 * <p>
 * JSON representation of NewsCollection
 * {
 * "status": "ok",
 * "source": "buzzfeed",
 * "sortBy": "popular",
 * "articles": [ … ]  <-- array of NewsArticle
 * }
 */
public class NewsCollection {
    private String status;
    private String source;
    private String sortBy;
    private NewsArticle[] articles;

    public String getStatus() {
        return status;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSource() {
        return source;
    }

    public NewsArticle[] getArticles() {
        return articles;
    }
}
