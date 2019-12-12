package com.sundeepk.spring.basic.api.domain;

import java.util.Objects;

public class XkcdComic {

    private String month;
    private int num;
    private String link;
    private String year;
    private String news;
    private String safe_title;
    private String transcript;
    private String alt;
    private String img;
    private String title;
    private String day;


    public XkcdComic(final String month, final int num, final String link, final String year, final String news,
                     final String safe_title, final String transcript, final String alt,
                     final String img, final String title, final String day) {
        this.month = month;
        this.num = num;
        this.link = link;
        this.year = year;
        this.news = news;
        this.safe_title = safe_title;
        this.transcript = transcript;
        this.alt = alt;
        this.img = img;
        this.title = title;
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public int getNum() {
        return num;
    }

    public String getLink() {
        return link;
    }

    public String getYear() {
        return year;
    }

    public String getNews() {
        return news;
    }

    public String getSafe_title() {
        return safe_title;
    }

    public String getTranscript() {
        return transcript;
    }

    public String getAlt() {
        return alt;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getDay() {
        return day;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final XkcdComic xkcdComic = (XkcdComic) o;
        return num == xkcdComic.num &&
               Objects.equals(month, xkcdComic.month) &&
               Objects.equals(link, xkcdComic.link) &&
               Objects.equals(year, xkcdComic.year) &&
               Objects.equals(news, xkcdComic.news) &&
               Objects.equals(safe_title, xkcdComic.safe_title) &&
               Objects.equals(transcript, xkcdComic.transcript) &&
               Objects.equals(alt, xkcdComic.alt) &&
               Objects.equals(img, xkcdComic.img) &&
               Objects.equals(title, xkcdComic.title) &&
               Objects.equals(day, xkcdComic.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, num, link, year, news, safe_title, transcript, alt, img, title, day);
    }

    @Override
    public String toString() {
        return "XkcdComic{" +
               "month='" + month + '\'' +
               ", num=" + num +
               ", link='" + link + '\'' +
               ", year='" + year + '\'' +
               ", news='" + news + '\'' +
               ", safe_title='" + safe_title + '\'' +
               ", transcript='" + transcript + '\'' +
               ", alt='" + alt + '\'' +
               ", img='" + img + '\'' +
               ", title='" + title + '\'' +
               ", day='" + day + '\'' +
               '}';
    }
}
