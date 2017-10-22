package com.example.denero.kodeclicker

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView

class ResultActivity:AppCompatActivity() {
    lateinit var congrView:TextView
    lateinit var commentView:TextView
    lateinit var restartButton:Button
    lateinit var animations:Animations
    var SCORE:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_screen)
        animations = Animations(this)
        SCORE = intent.getIntExtra("Score",0)
        congrView = findViewById(R.id.congr_view) as TextView
        commentView = findViewById(R.id.comment_view) as TextView
        restartButton = findViewById(R.id.restart_btn) as Button
        congrView.setText("Поздравляем вы нанесли:\n"+SCORE + " урона")
        checkResult()
        congrView.startAnimation(animations.animationScale)
        commentView.startAnimation(animations.animationScale)
    }


    fun checkResult(){
        if(SCORE>=1000){
            commentView.setText("ТЫ ВООБЩЕ ЧЕЛОВЕК?!")
        }
        else
        {
            if (SCORE>=500){
                commentView.setText("Хороший результат!")
            }
            else{
                if(SCORE>=250){
                    commentView.setText("Средний результат!")
                }
                else
                    commentView.setText("Плохо! Попробуй еще раз!")
            }
        }
    }

    fun restartGame(v: View){
        var intent = Intent(applicationContext,FightActivity::class.java)
        startActivity(intent)
    }
}