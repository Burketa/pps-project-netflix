package com.teamfive.trailerflix.model;

import android.media.Image;

import java.io.Serializable;

public class Trailer implements Serializable {

    public static final int ACAO = 0;
    public static final int COMEDIA = 1;

    private int category;
    private Image thumbnail;
    private String title;
    private String description;
    private int launchYear;
    private boolean isFavorite;
    private boolean feedback;
    private String trailerYoutubeId;

    private String urlVideo = "https://www.youtube.com/embed/";
    private String ulrThumb = "https://img.youtube.com/vi/";

    public Trailer() {

    }

    public Trailer(int category, Image thumbnail, String title, String description,
                   int launchYear, boolean isFavorite, String trailerYoutubeId) {
        this.category = category;
        this.thumbnail = thumbnail;
        this.title = title;
        this.description = description;
        this.launchYear = launchYear;
        this.isFavorite = isFavorite;
        this.trailerYoutubeId = trailerYoutubeId;
        this.urlVideo += trailerYoutubeId;
        this.ulrThumb += trailerYoutubeId + "/default.jpg";
    }

    public int getCategory() {
        return category;
    }

    public String getCategoryString() {
        switch (category)
        {
            case 0: return "Ação";
            case 1: return "Comédia";
            default: return "";
        }
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getTrailerYoutubeId() {
        return trailerYoutubeId;
    }

    public void setTrailerYoutubeId(String trailerYoutubeId) {
        this.trailerYoutubeId = trailerYoutubeId;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getUlrThumb() {
        return ulrThumb;
    }

    public void setUlrThumb(String ulrThumb) {
        this.ulrThumb = ulrThumb;
    }

    public boolean isFeedback() {
        return feedback;
    }

    public void setFeedback(boolean feedback) {
        this.feedback = feedback;
    }

}
