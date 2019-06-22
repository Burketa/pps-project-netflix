package com.teamfive.trailerflix.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

public class PlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private Trailer trailer;

    private YouTubePlayerView playerView;
    private TextView title;
    private TextView year;
    private TextView plot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Bundle b = getIntent().getExtras();
        
        trailer = (Trailer)b.getSerializable("trailer");

        //Referencias
        playerView = findViewById(R.id.player_view);
        title = findViewById(R.id.descricao_titulo);
        year = findViewById(R.id.descricao_ano);
        plot = findViewById(R.id.descricao_plot);
        //

        title.setText(trailer.getTitle());
        year.setText(trailer.getYear());
        plot.setText(trailer.getPlot());
        playerView.initialize(getResources().getString(R.string.youtube_key), this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        //youTubePlayer.setFullscreen(true);
        //youTubePlayer.setShowFullscreenButton(false);
        youTubePlayer.loadVideo(trailer.getTrailerYoutubeId());
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}