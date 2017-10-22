package com.example.denero.kodeclicker

import android.content.Intent
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by DENERO on 22.10.2017.
 */


class FightActivity:AppCompatActivity() {
    var time:Long = 30
    var score:Int = 0
    lateinit var timeView:TextView
    lateinit var healthView:TextView
    lateinit var damageView:TextView
    lateinit var textureEnemy:ImageView
    lateinit var enemy:Enemy
    lateinit var animations:Animations
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fight_screen)
        animations = Animations(this)
        timeView = findViewById(R.id.time_view) as TextView
        healthView = findViewById(R.id.health_view) as TextView
        damageView = findViewById(R.id.damage_view) as TextView
        textureEnemy = findViewById(R.id.image_enemy) as ImageView
        enemy = Enemy(textureEnemy,this,R.raw.basicmonster)
        asyncGame()
    }
    fun attackBot(v: View){
        score += 1
        enemy.takingDamage(5)
        damageView.text = "Нанесенный урон:"+score*5
        healthView.text = "Здоровье:"+enemy.health
        enemy.playSoundDamage()
        enemy.texture.startAnimation(animations.damageAnimation)
        if(enemy.health<=0){
            textureEnemy.setImageDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.diablo))
            enemy = Enemy(textureEnemy,applicationContext,R.raw.boss)
            enemy.health = 3000
        }
    }

    fun asyncGame(){
        AsyncTask.execute {
            while (true){
                if(time<=0){
                    var intent = Intent(applicationContext,ResultActivity::class.java)
                    intent.putExtra("Score",score*5)
                    startActivity(intent)
                    finish()
                    break
                }
                else{
                    time-=1
                    runOnUiThread{
                        if(time==15L)
                            timeView.setTextColor(Color.RED)
                            timeView.setText(time.toString()) }
                    Thread.sleep(1000)
               }
            }
        }

    }
}

