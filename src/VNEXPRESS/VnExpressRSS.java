package VNEXPRESS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class VnExpressRSS {
    public static void main(String[] args) {
        System.out.println(readRss("https://vnexpress.net/rss/kinh-doanh.rss"));
    }
    // Algorithm to read RSS feed and extract the title from https://www.youtube.com/watch?v=xiK-DH74oJg
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
                    if (temp.contains("</br>"))
                    {
                        firstPos = temp.indexOf("</br>");
                    }
                    else
                    {
                        firstPos = temp.indexOf("DATA[");
                    }
                    temp = temp.substring(firstPos + firstDesc, lastPos - finalDesc);
                    sourcecode += "Description: " + temp + "\n";

                    //Code to extract the image source from articles
                    if(line.contains("<img src=")){
                        final int firstImg = 1;
                        final int finalImg = 4;
                        temp = tempBuffer;
                        firstPos = temp.indexOf("<img src=");
                        lastPos = temp.indexOf("</a>");
                        temp = temp.substring(firstPos + firstImg, lastPos + finalImg);
                        temp = temp.replace("\" ></a>", "");
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
                    try {
                        date = formatter.parse(temp);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    sourcecode += "Date: " + date + "\n";
                }
                if (line.contains("<link>")) {
                    int firstPos = line.indexOf("<link>");
                    String temp = line.substring(firstPos);
                    temp = temp.replace("<link>", "");
                    int lastPos = temp.indexOf("</link>");
                    temp = temp.substring(0, lastPos);

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