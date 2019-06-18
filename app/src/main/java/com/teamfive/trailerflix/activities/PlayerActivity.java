package com.teamfive.trailerflix.activities;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

import java.io.Serializable;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {

    private Trailer trailer;

    private TextView title;
    private TextView description;
    private ImageView star;

    private CheckBox favorite;
    private RadioGroup feedback;

    int i = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_activity);

        Bundle b = getIntent().getExtras();
        
        trailer = (Trailer)b.getSerializable("trailer");

        //Referencias
        title = findViewById(R.id.movie_title);
        title.setText(trailer.getTitle());
        favorite = findViewById(R.id.cb_toast);
        feedback = findViewById(R.id.rg_case);
        /*star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                System.out.println(i);
                if(i % 2 == 0)
                {
                    star.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white_24dp, getTheme()));
                    trailer.setFavorite(true);
                }
                else
                {
                    star.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_white_24dp, getTheme()));
                    trailer.setFavorite(false);
                }
            }
        });*/
    }
}