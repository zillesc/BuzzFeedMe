package ninja.zilles;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zilles on 1/26/17.
 */
public class NewsCollectionTest {
    public static final String exampleArticle = "{\n" +
            "\"author\": \"Krystie Lee Yandoli\",\n" +
            "\"title\": \"Drake And Rihanna Kissed On Stage Again And I Am Literally Dead\",\n" +
            "\"description\": \"AUBRIH!\",\n" +
            "\"url\": \"https://www.buzzfeed.com/krystieyandoli/i-spilled-all-my-emotions-tonight-im-sorry\",\n" +
            "\"urlToImage\": \"https://img.buzzfeed.com/buzzfeed-static/static/2016-09/1/13/campaign_images/buzzfeed-prod-fastlane03/drake-and-rihanna-kissed-on-stage-again-and-i-am--2-32240-1472749696-0_dblbig.jpg\",\n" +
            "\"publishedAt\": \"2016-09-01T15:39:36Z\"\n" +
            "}";
    public static final String exampleCollection = "{\"status\":\"ok\",\"source\":\"buzzfeed\",\"sortBy\":\"popular\",\"articles\":[{\"author\":\"Krystie Lee Yandoli\",\"title\":\"Drake And Rihanna Kissed On Stage Again And I Am Literally Dead\",\"description\":\"AUBRIH!\",\"url\":\"https://www.buzzfeed.com/krystieyandoli/i-spilled-all-my-emotions-tonight-im-sorry\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-09/1/13/campaign_images/buzzfeed-prod-fastlane03/drake-and-rihanna-kissed-on-stage-again-and-i-am--2-32240-1472749696-0_dblbig.jpg\",\"publishedAt\":\"2016-09-01T15:39:36Z\"},{\"author\":\"Ryan Broderick, Jules Darmanin\",\"title\":\"Someone Made A Guide For What To Do When You See Islamophobia And It's Perfect\",\"description\":\"Step 1: Ignore the attacker.\",\"url\":\"https://www.buzzfeed.com/ryanhatesthis/someone-made-a-guide-for-what-to-do-when-you-see-islamophobi\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-08/31/12/campaign_images/buzzfeed-prod-fastlane01/someone-made-a-guide-for-what-to-do-when-you-see--2-22292-1472662779-1_dblbig.jpg\",\"publishedAt\":\"2016-08-31T13:36:57Z\"},{\"author\":\"Christine Byrne\",\"title\":\"27 Cheesy Dips That Everybody Will Love\",\"description\":\"Cheese will always be there for you. Cheese will never let you down.\",\"url\":\"https://www.buzzfeed.com/christinebyrne/just-cheesin\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-08/29/9/social_promotion/buzzfeed-prod-fastlane02/facebook-social-promotion-26270-1472479178-1.png\",\"publishedAt\":\"2016-08-31T12:04:05Z\"},{\"author\":\"Lauren Strapagiel\",\"title\":\"Parents Are Relating So Much To This Mom Who Lost It In A Grocery Store\",\"description\":\"Note to everyone: Stop judging parents.\",\"url\":\"https://www.buzzfeed.com/laurenstrapagiel/this-is-motherhood\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-09/1/13/campaign_images/buzzfeed-prod-fastlane02/parents-are-relating-so-much-to-this-mom-who-lost-2-3452-1472752276-0_dblbig.jpg\",\"publishedAt\":\"2016-08-31T17:25:26Z\"},{\"author\":\"Natalya Lobanova\",\"title\":\"How Terrible Are Your Vegetable Opinions?\",\"description\":\"Don't act like you don't have any opinions on vegetables.\",\"url\":\"https://www.buzzfeed.com/natalyalobanova/how-terrible-are-your-vegetable-opinions\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-09/1/13/social_promotion/buzzfeed-prod-cron01/facebook-social-promotion-598-1472749514-5.png\",\"publishedAt\":\"2016-09-01T13:11:59Z\"},{\"author\":\"Julie Gerstein\",\"title\":\"This Hidden-Rainbow Hair Is Gonna Give You All Kinds Of Hair Goals\",\"description\":\"Business on the top, party secreted away in the middle.\",\"url\":\"https://www.buzzfeed.com/juliegerstein/this-hidden-rainbow-hair-is-gonna-give-you-all-kinds-of-hair\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-08/31/16/campaign_images/buzzfeed-prod-fastlane02/this-hidden-rainbow-hair-is-gonna-give-you-all-ki-2-23416-1472673971-1_dblbig.jpg\",\"publishedAt\":\"2016-08-31T20:19:29Z\"},{\"author\":\"Sarah Karlan\",\"title\":\"Mark Ruffalo Addresses The Trans Community After Matt Bomer Casting Controversy\",\"description\":\"\\\"I hear you,\\\" the actor tweeted Wednesday.\",\"url\":\"https://www.buzzfeed.com/skarlan/i-hear-you\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-08/31/22/campaign_images/buzzfeed-prod-web08/mark-ruffalo-addresses-the-trans-community-after--2-24377-1472698782-0_dblbig.jpg\",\"publishedAt\":\"2016-08-31T23:45:53Z\"},{\"author\":\"Natalya Lobanova\",\"title\":\"21 Things You Know If You're Actually Secretly Bad At Makeup\",\"description\":\"You only actually know how to do one thing.\",\"url\":\"https://www.buzzfeed.com/natalyalobanova/things-you-know-if-youre-actually-secretly-bad-at-makeup\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-08/31/16/social_promotion/buzzfeed-prod-cron01/facebook-social-promotion-11880-1472673909-1.png\",\"publishedAt\":\"2016-08-31T16:17:54Z\"},{\"author\":\"Ellie Woodward\",\"title\":\"JK Rowling And Amy Schumer Just Had A Lovely Exchange On Twitter\",\"description\":\"Well, this is unexpectedly amazing.\",\"url\":\"https://www.buzzfeed.com/elliewoodward/jk-rowling-and-amy-schumer-just-had-a-lovely-exchange-on-twi\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-08/31/11/campaign_images/buzzfeed-prod-web14/jk-rowling-and-amy-schumer-just-had-a-lovely-exch-2-25848-1472656929-0_dblbig.jpg\",\"publishedAt\":\"2016-08-31T11:07:51Z\"},{\"author\":\"Ellie Bate\",\"title\":\"Here's How Harry Potter Actually Changed People's Lives\",\"description\":\"\\\"Harry Potter gave me a friend when I felt like I had none.\\\"\",\"url\":\"https://www.buzzfeed.com/eleanorbate/thank-you-jk-rowling\",\"urlToImage\":\"https://img.buzzfeed.com/buzzfeed-static/static/2016-09/1/7/social_promotion/buzzfeed-prod-fastlane01/facebook-social-promotion-16899-1472729309-1.jpg\",\"publishedAt\":\"2016-09-01T11:33:48Z\"}]}";


    Gson gson = new Gson();
    NewsArticle mArticle;
    NewsCollection mCollection;

    @Before
    public void parseJSON() {
        mArticle = gson.fromJson(exampleArticle, NewsArticle.class);
        mCollection = gson.fromJson(exampleCollection, NewsCollection.class);
    }

    @Test
    public void getStatus() throws Exception {
        assertEquals(mCollection.getStatus(), "ok");
    }

    @Test
    public void getSortBy() throws Exception {
        assertEquals(mCollection.getSortBy(), "popular");
    }

    @Test
    public void getSource() throws Exception {
        assertEquals(mCollection.getSource(), "buzzfeed");
    }

    @Test
    public void getArticles() throws Exception {
        NewsArticle[] articles = mCollection.getArticles();
        assertEquals(articles.length, 10);
        assertTrue(mArticle.equals(articles[0]));
    }

}