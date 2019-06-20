package com.teamfive.trailerflix.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Trailer implements Serializable {

    public static final int ACTION = 1;
    public static final int COMEDY = 2;

    public static final int UNRATED = 0;
    public static final int POSITIVE = 1;
    public static final int NEGATVIE = 2;

    private String trailerYoutubeId;
    private String trailerIMDBId;

    private String title;
    private int category;
    private String description;
    private int launchYear;
    private boolean isFavorite;
    private boolean feedback;
    private String json;

    public Trailer() {

    }

    public Trailer(String trailerIMDBId, String trailerYoutubeId,  boolean isFavorite,
                   boolean feedback) {
        this.trailerIMDBId = trailerIMDBId;
        this.trailerYoutubeId = trailerYoutubeId;
        this.isFavorite = isFavorite;
        this.feedback = feedback;
    }

    public Trailer(int category, String trailerIMDBId, String trailerYoutubeId,  boolean isFavorite,
                   boolean feedback) {
        this.category = category;
        this.trailerIMDBId = trailerIMDBId;
        this.trailerYoutubeId = trailerYoutubeId;
        this.isFavorite = isFavorite;
        this.feedback = feedback;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public int getCategory() {
        return category;
    }

    public String getCategoryString() {
        switch (category)
        {
            case 1: return "Ação";
            case 2: return "Comédia";
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

    public boolean getFeedback() {
        return feedback;
    }

    public void setFeedback(boolean feedback) {
        this.feedback = feedback;
    }

    public String getTrailerIMDBId() {
        return trailerIMDBId;
    }

    public void setTrailerIMDBId(String trailerIMDBId) {
        this.trailerIMDBId = trailerIMDBId;
    }

}
