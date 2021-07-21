package ZingNhandan.controller;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import ZingNhandan.model.*;

public class zingscrap {
        public static String list_paper_zing(String source, ArrayList<FeedItem> feedItems) {
        try {
            Document doc = Jsoup.connect(source).timeout(6000).get();
            Elements zingTable = doc.select("article");
            for (Element header : zingTable.select("header")) {
                Elements Title_selection = header.select("p.article-title");

                String title = Title_selection.select("a").text();
                Elements check = header.select("p.article-meta");

                String pubDate = check.select("span.article-publish span.date").text()
                        .concat(check.select("span.article-publish span.friendly-time").text());
                        

                String link = check.select("a").attr("href");

                String description = header.select("p.article-summary").text();

                Elements img_detail = zingTable.select("p.article-thumbnail a");
                String thumbnail = img_detail.select("img").attr("data-src");

                feedItems.add(new FeedItem(title, description, pubDate, thumbnail, link, "Khoa học - Công nghệ", "ZingNews"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String list_read_zing(String Link) {
        String HomePageZing = "https://zingnews.vn/";
        try {
            Document doc = Jsoup.connect(HomePageZing.concat(Link)).timeout(6000).get();
                Elements zingHeader = doc.select("div.page-wrapper article ");
                for (Element rows : zingHeader) {
                    String Desc = rows.select("p").text();
                    System.out.println(Desc);
                    String image = rows.select("table tr td.pic img").attr("data-src");
                    System.out.println(image);

                    String header_detail = zingHeader.select("header.the-article-header p").text();
                    String header_detail1 = zingHeader.select("header.the-article-header h1").text();
                    String header_detail2 = zingHeader.select("header.the-article-header ul.the-article-meta li")
                            .text();
                    System.out.println(header_detail);
                    System.out.println(header_detail1);
                    System.out.println(header_detail2);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String list_zing_home(String zingUrl, ArrayList<FeedItem> news_homepage) {
        try {
            Document doc = Jsoup.connect(zingUrl).timeout(6000).get();
            Elements zingTable = doc.select("article");
            for (Element header : zingTable.select("header")) {
                Elements Title_selection = header.select("p.article-title");

                String title = Title_selection.select("a").text();
                Elements check = header.select("p.article-meta");

                String pubDate = check.select("span.article-publish span.friendly-time").text()
                        .concat(check.select("span.article-publish span.date").text());

                String link = check.select("a").attr("href");

                String description = header.select("p.article-summary").text();

                Elements img_detail = zingTable.select("p.article-thumbnail a");
                String thumbnail = img_detail.select("img").attr("data-src");

                news_homepage.add(new FeedItem(title, description, pubDate, thumbnail, link, "HomePage", "ZingNews"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
