package com.example.denero.kodeclicker

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.widget.ImageView

/**
 * Created by DENERO on 22.10.2017.
 */
class Enemy(image:ImageView,context: Context,resSoundId:Int) {
    var health:Int = 100
    var texture:ImageView
    var mp :MediaPlayer

    init {
        texture=image
        mp = MediaPlayer.create(context, resSoundId)
    }

    fun takingDamage(attack:Int){
        health-=attack
    }
    fun playSoundDamage(){
        mp.start();
    }
    fun loadSoundDamage(context: Context,resId: Int){
        mp = MediaPlayer.create(context, resId)
    }
}