package ninja.zilles;

/**
 * Created by zilles on 9/1/16.
 *
 * Representation of the JSON returned from:
 *           https://newsapi.org/v1/articles?source=buzzfeed&sortBy=popular&apiKey=YOUR_API_KEY_HERE
 */


//  JSON representation of NewsArticle
//    {
//        "author": "Krystie Lee Yandoli",
//        "title": "Drake And Rihanna Kissed On Stage Again And I Am Literally Dead",
//        "description": "AUBRIH!",
//        "url": "https://www.buzzfeed.com/krystieyandoli/i-spilled-all-my-emotions-tonight-im-sorry",
//        "urlToImage": "https://img.buzzfeed.com/buzzfeed-static/static/2016-09/1/13/campaign_images/buzzfeed-prod-fastlane03/drake-and-rihanna-kissed-on-stage-again-and-i-am--2-32240-1472749696-0_dblbig.jpg",
//        "publishedAt": "2016-09-01T15:39:36Z"
//    }
public class NewsArticle {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NewsArticle)) {
            return false;
        }

        NewsArticle other = (NewsArticle) obj;
        return other.author.equals(author) &&
                other.title.equals(title) &&
                other.description.equals(description) &&
                other.url.equals(url) &&
                other.urlToImage.equals(urlToImage) &&
                other.publishedAt.equals(publishedAt);
    }


    //  JSON representation of NewsCollection
    //    {
    //        "status": "ok",
    //        "source": "buzzfeed",
    //        "sortBy": "popular",
    //        "articles": [ … ]  <-- array of NewsArticle
    //    }
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
}
