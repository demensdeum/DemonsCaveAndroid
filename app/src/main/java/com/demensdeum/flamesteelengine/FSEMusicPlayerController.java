package com.demensdeum.flamesteelengine;

import android.content.Context;
import android.media.MediaPlayer;

import com.demensdeum.demonscave.R;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by demensdeum on 04.06.16.
 */
public class FSEMusicPlayerController implements MediaPlayer.OnCompletionListener {

    private Context context;
    protected MediaPlayer mediaPlayer;
    private int currentTrackIndex = -1;

    private LinkedList<Integer> resourcesIds;

    public FSEMusicPlayerController(Context context) {
        this.context = context;
        resourcesIds = new LinkedList<Integer>();
    }

    public void addTrack(int resourceId) {
        resourcesIds.push(resourceId);
    }

    public void shuffle() {
        Collections.shuffle(resourcesIds);
    }

    public void play() {
        this.playNextTrack();
    }

    public void playNextTrack() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        if (this.resourcesIds.size() > 0) {


            if (this.currentTrackIndex == -1) {
                this.currentTrackIndex = 0;
            } else if (this.currentTrackIndex >= this.resourcesIds.size()) {
                this.currentTrackIndex = 0;
            }
            else
            {
                this.currentTrackIndex++;
            }

            int resourceId = this.resourcesIds.get(this.currentTrackIndex);

            this.mediaPlayer = MediaPlayer.create(context, resourceId);
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(this);

        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        this.playNextTrack();
    }

    public void resume() {
        mediaPlayer.start();
    }

    public void pause() {
        mediaPlayer.pause();
    }
}
