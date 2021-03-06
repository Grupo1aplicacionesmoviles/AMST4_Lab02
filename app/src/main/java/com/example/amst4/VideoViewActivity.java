package com.example.amst4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoViewActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String claveyoutube = "AIzaSyBXvHjHafL-ssDY1rgSVhVwSJX_boXG_tc";
    YouTubePlayerView youTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        youTubePlayerView= findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(claveyoutube,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fuerestaurado)
    {
        if(!fuerestaurado){
            youTubePlayer.cueVideo("azxDhcKYku4");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();


        }else{
            String error="Error al incializar Youtube" + youTubeInitializationResult.toString();
            Toast.makeText(getApplication(),error,Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultcode, Intent data){
        if(resultcode==1){
            getYoutubePlayerProvider().initialize(claveyoutube,this);
        }
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider(){
        return  youTubePlayerView;
    }
    //Comentario
}