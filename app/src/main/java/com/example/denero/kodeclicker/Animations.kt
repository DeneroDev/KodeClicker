package com.example.denero.kodeclicker

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils

/**
 * Created by DENERO on 22.10.2017.
 */
class Animations(context: Context) {
    var animationScale: Animation
    var damageAnimation:Animation
    init {
         animationScale = AnimationUtils.loadAnimation(context,R.anim.start_button_anim)
         damageAnimation = AnimationUtils.loadAnimation(context,R.anim.attack_anim)
    }

}