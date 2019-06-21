package com.teamfive.trailerflix.model;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrailerTest {

    @Test
    public void getJson() {
    }

    @Test
    public void setJson() {
    }

    @Test
    public void getCategory() {
        Trailer t = new Trailer(9,"","",true);
        int result = t.getCategory();

        assertNotNull(t);
    }

    @Test
    public void getCategoryString() {
    }

    @Test
    public void setCategory() {
    }

    @Test
    public void getTitle() {
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void setDescription() {
    }

    @Test
    public void isFavorite() {
    }

    @Test
    public void setFavorite() {
    }

    @Test
    public void getTrailerYoutubeId() {
    }

    @Test
    public void setTrailerYoutubeId() {
    }

    @Test
    public void getFeedback() {
    }

    @Test
    public void setFeedback() {
    }

    @Test
    public void getTrailerIMDBId() {
    }

    @Test
    public void setTrailerIMDBId() {
    }

    @Test
    public void compareTo() {
    }
}