package ZingNhandan.App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import ZingNhandan.controller.zingscrap;
import ZingNhandan.model.FeedItem;

import ZingNhandan.controller.nhandanScraper;

public class zingtrangchu {
    public static List<FeedItem> feedItems = new ArrayList<>();
    public static List<FeedItem> news_homepage = new ArrayList<>();
    public static String HomePageZing = "https://zingnews.vn/";
    public static String NhanDanNews = "https://nhandan.vn/";

    public static void main(String[] args) throws IOException {

        String catory_check = "";
        System.out.println("Enter your catogary news: ");
        Scanner input = new Scanner(System.in);
        catory_check = input.nextLine();

        switch (catory_check.toLowerCase()) {
            case "congnghe":
                String zingcongnghe = HomePageZing.concat("cong-nghe.html");
                String NhanDancongnghe = NhanDanNews.concat("khoahoc-congnghe");
                nhandanScraper.list_paper_nhandan(NhanDancongnghe, (ArrayList<FeedItem>) feedItems);
                zingscrap.list_paper_zing(zingcongnghe, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory.getTitle());
                    System.out.println(news_catory.getPubDate());
                    System.out.println(news_catory.getThumbnail());
                    System.out.println(news_catory.getDescription());
                });
                break;
            case "thethao":
                String zingthethao = HomePageZing.concat("the-thao.html");
                String NhanDanthethao = NhanDanNews.concat("thethao");
                nhandanScraper.list_paper_nhandan(NhanDanthethao, (ArrayList<FeedItem>) feedItems);
                zingscrap.list_paper_zing(zingthethao, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory.getTitle());
                    System.out.println(news_catory.getPubDate());
                    System.out.println(news_catory.getThumbnail());
                    System.out.println(news_catory.getDescription());
                });
                break;
            case "giaitri":
                String zinggiaitri = HomePageZing.concat("giai-tri.html");
                zingscrap.list_paper_zing(zinggiaitri, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory.getTitle());
                    System.out.println(news_catory.getPubDate());
                    System.out.println(news_catory.getThumbnail());
                    System.out.println(news_catory.getDescription());
                });
                break;
            case "kinhdoanh":
                String zingtaichinh = HomePageZing.concat("kinh-doanh-tai-chinh.html");
                String nhandankinhte = NhanDanNews.concat("kinhte");
                nhandanScraper.list_paper_nhandan(nhandankinhte, (ArrayList<FeedItem>) feedItems);
                zingscrap.list_paper_zing(zingtaichinh, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory.getTitle());
                    System.out.println(news_catory.getPubDate());
                    System.out.println(news_catory.getThumbnail());
                    System.out.println(news_catory.getDescription());
                });
                break;
            case "thegioi":
                String zingthegioi = HomePageZing.concat("the-gioi.html");
                String nhandanthegioi = NhanDanNews.concat("thegioi");
                nhandanScraper.list_paper_nhandan(nhandanthegioi, (ArrayList<FeedItem>) feedItems);
                zingscrap.list_paper_zing(zingthegioi, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory.getTitle());
                    System.out.println(news_catory.getPubDate());
                    System.out.println(news_catory.getThumbnail());
                    System.out.println(news_catory.getDescription());
                });
                break;
            case "thoisu":
                String zingthoisu = HomePageZing.concat("thoi-su.html");
                String nhandanthoisu = NhanDanNews.concat("phapluat");
                zingscrap.list_paper_zing(zingthoisu, (ArrayList<FeedItem>) feedItems);
                nhandanScraper.list_paper_nhandan(nhandanthoisu, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory.getTitle());
                    System.out.println(news_catory.getPubDate());
                    System.out.println(news_catory.getThumbnail());
                    System.out.println(news_catory.getDescription());
                });
                break;
            case "doisong":
                String zingdoisong = HomePageZing.concat("doi-song.html");
                String nhandandoisong = NhanDanNews.concat("vanhoa");
                nhandanScraper.list_paper_nhandan(nhandandoisong, (ArrayList<FeedItem>) feedItems);
                zingscrap.list_paper_zing(zingdoisong, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory.getTitle());
                    System.out.println(news_catory.getPubDate());
                    System.out.println(news_catory.getThumbnail());
                    System.out.println(news_catory.getDescription());
                });
                break;
            default:
                zingscrap.list_zing_home(HomePageZing, (ArrayList<FeedItem>) news_homepage);
                nhandanScraper.list_paper_nhandan(NhanDanNews, (ArrayList<FeedItem>) news_homepage);
                news_homepage.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory.getTitle());
                    System.out.println(news_catory.getPubDate());
                    System.out.println(news_catory.getThumbnail());
                    System.out.println(news_catory.getDescription());
                });
                break;
        }
    }
}
