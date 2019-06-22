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

        if(b != null) {
            trailer = (Trailer) b.getSerializable("trailer");
            setReferences();
            configReferences();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(trailer.getTrailerYoutubeId());
        //youTubePlayer.setFullscreen(true);
        //youTubePlayer.setShowFullscreenButton(false);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    public void setReferences()
    {
        playerView = findViewById(R.id.player_view);
        title = findViewById(R.id.description_title);
        year = findViewById(R.id.description_year);
        plot = findViewById(R.id.description_plot);
    }

    public void configReferences()
    {
        title.setText(trailer.getTitle());
        year.setText(trailer.getYear());
        plot.setText(trailer.getPlot());
        playerView.initialize(getResources().getString(R.string.youtube_key), this);
    }
}