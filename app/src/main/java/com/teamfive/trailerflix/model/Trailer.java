package com.teamfive.trailerflix.model;

import java.io.Serializable;

public class Trailer implements Serializable {

    public static final int ACAO = 0;
    public static final int COMEDIA = 1;

    private String trailerYoutubeId;
    private String title;
    private int category;
    private String description;
    private int launchYear;
    private boolean isFavorite;
    private boolean feedback;

    public Trailer() {

    }

    public Trailer(int category, String trailerYoutubeId, String title, String description,
                   int launchYear, boolean isFavorite, boolean feedback) {
        this.trailerYoutubeId = trailerYoutubeId;
        this.title = title;
        this.category = category;
        this.description = description;
        this.launchYear = launchYear;
        this.isFavorite = isFavorite;
        this.feedback = feedback;
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

    public boolean isFeedback() {
        return feedback;
    }

    public void setFeedback(boolean feedback) {
        this.feedback = feedback;
    }

}
