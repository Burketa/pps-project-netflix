package com.teamfive.trailerflix.model;

import java.io.Serializable;

public class Trailer implements Serializable, Comparable<Trailer> {

    public static final int ACTION = 1;
    public static final int ADVENTURE = 2;
    public static final int COMEDY = 3;
    public static final int FICTION = 4;
    public static final int TERROR = 5;

    public static final int UNRATED = 0;
    public static final int POSITIVE = 1;
    public static final int NEGATVIE = 2;

    private String trailerYoutubeId;
    private String trailerIMDBId;

    private boolean isFavorite;
    private String title;
    private String year;
    private String imdbRating;
    private String plot;
    private String json;
    private int feedback;
    private int category;

    public Trailer() {

    }

    public Trailer(String trailerIMDBId, String trailerYoutubeId, boolean isFavorite) {
        this.trailerIMDBId = trailerIMDBId;
        this.trailerYoutubeId = trailerYoutubeId;
        this.isFavorite = isFavorite;
    }

    public Trailer(int category, String trailerIMDBId, String trailerYoutubeId, boolean isFavorite) throws IllegalArgumentException {

        if (category < 0 || category > 5) {
            throw new IllegalArgumentException("Categoria não pode ser maior do que as declaradas.");
        }

        if (trailerIMDBId == null || trailerIMDBId.isEmpty()) {
            throw new IllegalArgumentException("IMDbId não pode ser nulo.");
        }

        if (trailerYoutubeId == null || trailerYoutubeId.isEmpty()) {
            throw new IllegalArgumentException("YoutubeId não pode ser nulo.");
        }

        this.category = category;
        this.trailerIMDBId = trailerIMDBId;
        this.trailerYoutubeId = trailerYoutubeId;
        this.isFavorite = isFavorite;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
        switch (category) {
            case 1:
                return "Ação";
            case 2:
                return "Comédia";
            default:
                return "";
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

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
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

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public String getTrailerIMDBId() {
        return trailerIMDBId;
    }

    public void setTrailerIMDBId(String trailerIMDBId) {
        this.trailerIMDBId = trailerIMDBId;
    }

    @Override
    public int compareTo(Trailer o) {
        if (getTitle() != null)
            return this.getTitle().compareTo(o.getTitle());
        else
            return 0;
    }
}
