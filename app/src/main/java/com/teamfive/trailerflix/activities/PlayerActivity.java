package com.teamfive.trailerflix.activities;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

public class PlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private Trailer trailer;

    private TextView title;
    private CheckBox favorite;
    private RadioGroup feedback;

    private YouTubePlayerView playerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Bundle b = getIntent().getExtras();
        
        trailer = (Trailer)b.getSerializable("trailer");

        //Referencias
        title = findViewById(R.id.movie_title);
        favorite = findViewById(R.id.cb_favorite);
        feedback = findViewById(R.id.rg_feedback);
        playerView = findViewById(R.id.player_view);

        //Setup
        title.setText(trailer.getTitle());
        favorite.setChecked(trailer.isFavorite());


        playerView.initialize(getResources().getString(R.string.youtube_key), this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        //TODO: pensar em um jeito de deixar legal pra dar um play no video automatico
        youTubePlayer.setFullscreen(true);
        //youTubePlayer.setShowFullscreenButton(false);
        youTubePlayer.loadVideo( trailer.getTrailerYoutubeId() );
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}