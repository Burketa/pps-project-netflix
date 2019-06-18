package com.teamfive.trailerflix.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

public class PlayerActivity extends AppCompatActivity {

    private Trailer trailer;

    private TextView title;
    private TextView description;
    private ImageView star;

    private CheckBox favorite;
    private RadioGroup feedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_activity);

        Bundle b = getIntent().getExtras();
        
        trailer = (Trailer)b.getSerializable("trailer");

        //Referencias
        title = findViewById(R.id.movie_title);
        title.setText(trailer.getTitle());
        favorite = findViewById(R.id.cb_favorite);
        feedback = findViewById(R.id.rg_feedback);
    }
}