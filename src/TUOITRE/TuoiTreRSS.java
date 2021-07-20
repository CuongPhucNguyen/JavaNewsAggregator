package TUOITRE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TuoiTreRSS {
    public static void main(String[] args) {
        System.out.println(readRss("https://tuoitre.vn/rss/tin-moi-nhat.rss"));
    }
    // Algorithm to read RSS feed from https://www.youtube.com/watch?v=xiK-DH74oJg
    public static String readRss(String url) {
        try {
            URL Url = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(Url.openStream()));
            String sourcecode = "";
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("<title>")) {
                    int firstPos = line.indexOf("<title>");
                    String temp = line.substring(firstPos);
                    temp = temp.replace("<title>", "");
                    int lastPos = temp.indexOf("</title>");
                    temp = temp.substring(0, lastPos);
                    if(temp.contains("<![CDATA["))
                    {
                        temp = temp.replace("<![CDATA[", "");
                        temp = temp.replace("]]>", "");
                    }
                    sourcecode += "Title: " + temp + "\n";
                }
                //Code to extract the description from articles
                if (line.contains("<description>")) {
                    final int finalDesc = 3;
                    final int firstDesc = 5;
                    int firstPos = line.indexOf("<description>");
                    String temp = line.substring(firstPos);
                    temp = temp.replace("<description>", "");
                    int lastPos = temp.indexOf("</description>");
                    temp = temp.substring(0, lastPos);
                    String tempBuffer = temp;
                    if (temp.contains("TTO - "))
                    {
                        firstPos = temp.indexOf("TTO - ");
                    }
                    temp = temp.substring(firstPos + firstDesc, lastPos - finalDesc);
                    if (temp.contains("</a>"))
                    {
                        final int formatPos = 10;
                        int pos = temp.indexOf("</a>");
                        temp = temp.substring(pos);
                        temp = temp.replace("</a>TTO – ","");
                    }
                    sourcecode += "Description: " + temp + "\n";

                    //Code to extract the image source from articles
                    if(line.contains("<img src=")){
                        final int firstImg = 1;
                        final int finalImg = 4;
                        temp = tempBuffer;
                        firstPos = temp.indexOf("<img src=");
                        lastPos = temp.indexOf("\" />");
                        temp = temp.substring(firstPos + firstImg, lastPos + finalImg);
                        temp = temp.replace("\" />", "");
                        temp = temp.replace("img src=\"", "");
                        sourcecode += "Image source: " + temp + "\n";
                    }
                }
                //Extracting published date from RSS feed into string and date format
                if (line.contains("<pubDate>")) {
                    DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
                    Date date = new Date();
                    int firstPos = line.indexOf("<pubDate>");
                    String temp = line.substring(firstPos);
                    temp = temp.replace("<pubDate>", "");
                    int lastPos = temp.indexOf("</pubDate>");
                    temp = temp.substring(0, lastPos);
                    if(temp.contains("<![CDATA["))
                    {
                        temp = temp.replace("<![CDATA[", "");
                        temp = temp.replace("]]>", "");
                    }
                    if(temp.contains("GMT+7"))
                    {
                        temp = temp.replace("GMT+7", "+0700");
                    }
                    try {
                        date = formatter.parse(temp);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    sourcecode += "Date: " + date + "\n";
                }
                //Code to extract link of article
                if (line.contains("<link>")) {
                    int firstPos = line.indexOf("<link>");
                    String temp = line.substring(firstPos);
                    temp = temp.replace("<link>", "");
                    int lastPos = temp.indexOf("</link>");
                    temp = temp.substring(0, lastPos);
                    if(temp.contains("<![CDATA["))
                    {
                        temp = temp.replace("<![CDATA[", "");
                        temp = temp.replace("]]>", "");
                    }
                    sourcecode += "Link: " + temp + "\n";
                }

            }
            in.close();
            return sourcecode;
        } catch (MalformedURLException ue) {
            System.out.println("Bad URL");
        } catch (IOException ioe) {
            System.out.println("Something went wrong reading the content");
        }
        return null;
    }

}
//Sun, 18 Jul 2021 18:44:30 +0700