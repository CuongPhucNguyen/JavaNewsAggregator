package ZingNhandan.controller;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import ZingNhandan.model.*;

public class nhandanScraper {
    public static String list_paper_nhandan (String nhandanurl, ArrayList<FeedItem> nhandaNnews) {
        try {
            Document doc = Jsoup.connect(nhandanurl).timeout(6000).get();
            Elements nhandantable = doc.select("article");

            for (Element header : nhandantable.select("div.box-img")) {
                String title = header.select("a").attr("title");
                String link = header.select("a").attr("href");

                Elements img_page = nhandantable.select("div.box-img a");
                String thumbnail = img_page.select("img").attr("data-src");

                String description = nhandantable.select("div.box-des p").text();

                String pubDate = nhandantable.select("div.box-meta-small").text();

                nhandaNnews.add(new FeedItem(title, description, pubDate, thumbnail, link, "Trang chu", "Nhan dan"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String ad (String nhandanurl, ArrayList<FeedItem> nhandaNnews) {
        try {
            Document doc = Jsoup.connect(nhandanurl).timeout(6000).get();
            Elements nhandantable = doc.select("article");

            for (Element header : nhandantable.select("div.box-img")) {
                String title = header.select("a").attr("title");
                String link = header.select("a").attr("href");

                Elements img_page = nhandantable.select("div.box-img a");
                String thumbnail = img_page.select("img").attr("data-src");

                String description = nhandantable.select("div.box-des p").text();

                String pubDate = nhandantable.select("div.box-meta-small").text();

                nhandaNnews.add(new FeedItem(title, description, pubDate, thumbnail, link, "Trang chu", "Nhan dan"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}