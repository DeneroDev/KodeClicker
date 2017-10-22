package com.example.denero.kodeclicker

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast

/**
 * Created by DENERO on 22.10.2017.
 */
class MainActivity: AppCompatActivity() {
    lateinit var startGameBtn:Button
    lateinit var animations:Animations
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
        startGameBtn = findViewById(R.id.start_game_btn) as Button
        animations = Animations(this)
        startGameBtn.startAnimation(animations.animationScale)
    }

    fun startGame(v: View){
        var intent = Intent(applicationContext,FightActivity::class.java)
        startActivity(intent)
    }
}