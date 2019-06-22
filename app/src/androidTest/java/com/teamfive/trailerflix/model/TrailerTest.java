package com.teamfive.trailerflix.model;

import com.teamfive.trailerflix.utils.Data;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrailerTest {

    @Test(expected = IllegalArgumentException.class)
    public void categoriaAbaixoDoRangePossivel() {
        Trailer t = new Trailer(-5, "a", "a", true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void categoriaAcimaDoRangePossivel() {
        Trailer t = new Trailer(10, "a", "a", true);
    }

    @Test
    public void categoriaEstaNoRangePossivel() {
        Trailer t = new Trailer(1, "a", "a", true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void imdbIDStringVazia() {
        Trailer t = new Trailer(1,"", "a", true);
    }

    @Test
    public void imdbIDStringnaoVazia() {
        Trailer t = new Trailer(1,"a", "a", true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void youtubeIdStringVazia() {
        Trailer t = new Trailer(1,"a", "", true);
    }

    @Test
    public void youtubeIdStringNaoVazia() {
        Trailer t = new Trailer(1,"a", "a", true);
    }

}