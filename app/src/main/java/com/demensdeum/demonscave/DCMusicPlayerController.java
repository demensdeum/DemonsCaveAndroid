package com.demensdeum.demonscave;

import android.content.Context;

import com.demensdeum.flamesteelengine.FSEMusicPlayerController;

/**
 * Created by demensdeum on 04.06.16.
 */
public class DCMusicPlayerController extends FSEMusicPlayerController {
    DCMusicPlayerController(Context context) {
        super(context);
        this.addTrack(R.raw.bensound_dance);
        this.addTrack(R.raw.bensound_dubstep);
        this.addTrack(R.raw.bensound_funkyelement);
        this.addTrack(R.raw.bensound_moose);
        this.addTrack(R.raw.bensound_popdance);
        this.addTrack(R.raw.juanitos_hola_hola_bossa_nova);
        this.addTrack(R.raw.michett_bitch_please);
        this.addTrack(R.raw.michett_planes);
        this.addTrack(R.raw.the_zombie_dandies_halloween_again);
        this.shuffle();
    }
}
