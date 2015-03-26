package com.example.angel.viewpager2;

/**
 * Created by Angel on 09/03/2015.
 */
public class Post {
    private String title;
    private String author;
    private String creationDate;
    private Long points;
    private Long quanComments;
    private String vote;



    private String imageUrl;
    private int imageWidth;
    private int imageHeight;

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Long getQuanComments() {
        return quanComments;
    }

    public void setQuanComments(Long quanComments) {
        this.quanComments = quanComments;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getVote() { return vote;}

    public void setVote(String vote) {this.vote = vote;}
}
