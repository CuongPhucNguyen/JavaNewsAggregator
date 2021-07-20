package zing.App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import zing.controller.zingscrap;
import zing.model.FeedItem;

public class zingtrangchu {
    public static void main(String[] args) throws IOException {
        List<FeedItem> feedItems = new ArrayList<>();
        List<FeedItem> news_homepage = new ArrayList<>();
        String HomePageZing = "https://zingnews.vn/";
        String catory_check = "";
        System.out.println("Enter your catogary news: ");
        Scanner input = new Scanner(System.in);
        catory_check = input.nextLine();

        switch (catory_check.toLowerCase()) {
            case "congnghe":
                String zingcongnghe = HomePageZing.concat("cong-nghe.html");
                zingscrap.list_paper_zing(zingcongnghe, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory);
                });
                break;
            case "thethao":
                String zingthethao = HomePageZing.concat("the-thao.html");
                zingscrap.list_paper_zing(zingthethao, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory);
                });
                break;
            case "giaitri":
                String zinggiaitri = HomePageZing.concat("giai-tri.html");
                zingscrap.list_paper_zing(zinggiaitri, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory);
                });
                break;
            case "kinhdoanh":
                String zingtaichinh = HomePageZing.concat("kinh-doanh-tai-chinh.html");
                zingscrap.list_paper_zing(zingtaichinh, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory);
                });
                break;
            case "thegioi":
                String zingthegioi = HomePageZing.concat("the-gioi.html");
                zingscrap.list_paper_zing(zingthegioi, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory);
                });
                break;

            case "thoisu":
                String zingthoisu = HomePageZing.concat("thoi-su.html");
                zingscrap.list_paper_zing(zingthoisu, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory);
                });
                break;
            case "doisong":
                String zingdoisong = HomePageZing.concat("doi-song.html");
                zingscrap.list_paper_zing(zingdoisong, (ArrayList<FeedItem>) feedItems);
                feedItems.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory);
                });
                break;
            default:
                zingscrap.list_zing_home(HomePageZing, (ArrayList<FeedItem>) news_homepage);
                news_homepage.parallelStream().forEach((news_catory) -> {
                    System.out.println(news_catory);
                });
                break;
        }
    }
}
