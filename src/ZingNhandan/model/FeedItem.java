package ZingNhandan.model;

public class FeedItem {
    private String title;
    private String description;
    private String pubDate;
    private String thumbnail;
    private String link;
    private String category;
    private String name;

    public FeedItem(String title, String description, String pubDate, String thumbnail, String link, String category,
            String name) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.thumbnail = thumbnail;
        this.link = link;
        this.category = category;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return limit(description, 100);
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLink() {
        return link;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "=======\nTiêu đề: " + title + "\n" + ", xuất bản vào ngày: :" + pubDate + "\n" + ", Tóm tắt: "
                + description + "\n" + ", Ảnh minh họa: " + thumbnail + "\n" + ", Đường Dẫn:" + link + "=======\n";
    }

    public static String limit(String value, int length) {
        StringBuilder buf = new StringBuilder(value);
        if (buf.length() > length) {
            buf.setLength(length);
            buf.append("...");
        }
        return buf.toString();
    }
}
