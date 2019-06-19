package com.teamfive.trailerflix.utils;

import com.teamfive.trailerflix.model.Trailer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    public static List<Trailer> trailerList = Arrays.asList(
            new Trailer(0, "bldAkEUANWA", "Mulher Maravilha", "Filmão !", 2018, true, false),
            new Trailer(0, "g6ng8iy-l0U", "Vingadores: Ultimato", "Preciso assistir :(", 2019, false, true),
            new Trailer(1, "wmiIUN-7qhE", "Toy Story 4", "Pra toda familia", 2019, false, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, true),
            //
            new Trailer(1, "qk7AkLgXK4k", "Chorar de Rir", "Com Leandro Hassum", 2019, false,
                    true),
            new Trailer(1, "QxsWq53cV80", "As Trapaceiras", "Com Anne Hathaway !", 2019, false,
                    false),
            new Trailer(1, "FWFMr44Rmjw", "De Pernas Pro Ar 3", "Quebrando taboos", 2019, true,
                    false),
            new Trailer(1, "FQFPrMNcDhA", "Casal Improvavel", "Better Call Saul feelings",
                        2019, false, false),
            new Trailer(1, "AVdjEY4BMxs", "Sai De Baixo", "hahahaha !", 2019, false, false),
            new Trailer(0, "KarvuJWMLjI", "Um Espião Animal", "Animação de Ação", 2019, false,
                    false),
            new Trailer(0, "cdAZYIgdh6M", "Polar", "Descrição legal aqui", 2019, true, false)
            //
            /*new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, false, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, false, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, false, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, false, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, false, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, false, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, false),
            new Trailer(1, "PRyOvcOhtms", "Alladin", "Classico !", 2019, true, false)*/
            //

    );

    public static List<Trailer> favoriteList = new ArrayList<>();

    public static void updateFavorites()
    {
        favoriteList.clear();

        for(Trailer t : trailerList)
        {
            if(t.isFavorite())
                favoriteList.add(t);
        }
    }
}
