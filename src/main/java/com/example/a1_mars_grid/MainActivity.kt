package com.example.a1_mars_grid

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardTitles : Array<String> = resources.getStringArray(R.array.cardTitles)
        val cardImages : Array<String> = resources.getStringArray(R.array.cardImages)


        val adapter = GridItemAdapter(cardTitles,cardImages)
        val gridLayout = GridLayoutManager(this, 8)
        gridItems.layoutManager = gridLayout
        gridItems.adapter = adapter

    //    holder.cardImage.setImageDrawable(getDrawable(R.drawable.rectgreen))

        var click = findViewById<ImageView>(R.id.myImage)

        click.setOnClickListener{
            click.setImageDrawable(getDrawable(R.drawable.rectred))
     //       playSound(true)
        }

        var playAgainBtn = findViewById<Button>(R.id.playAgainBtn)

        playAgainBtn.setOnClickListener {
            arrayOfRows = Array(9) {ArrayList<Int>(Collections.nCopies(9, 0)) }
            arrayOfColumns = Array(9) {ArrayList<Int>(Collections.nCopies(9, 0)) }
            adapter.notifyDataSetChanged()
        }





        countdown()

    }


    fun countdown() {

        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if (Winner != 0){
                    playSound(true)
                    Winner = 0
                }
            }

            override fun onFinish() {
                //            testar()
                countdown()
            }
        }.start()
    }

    fun playSound(start : Boolean) {

        var textIgen = findViewById<TextView>(R.id.textigen)

        var resId = getResources().getIdentifier(
            R.raw.gronfyra1.toString(),
            "raw", this?.packageName
        )

        if (Winner == 1) {
            resId = getResources().getIdentifier(
                R.raw.gronfyra.toString(),
                "raw", this?.packageName

            )

            mediaPlayer = MediaPlayer.create(this, resId)
            textIgen.text = "Grön har fyra i rad"
        }
        else
        {
            resId = getResources().getIdentifier(
                R.raw.rodfyra.toString(),
                "raw", this?.packageName

            )
            mediaPlayer = MediaPlayer.create(this, resId)
            textIgen.text = "Röd har fyra i rad"
        }


        if (start) {
            if(mediaPlayer == null)
            {
 //               mediaPlayer = MediaPlayer.create(this, resId)
                mediaPlayer!!.start()
            } else {
                mediaPlayer!!.seekTo(0)
                mediaPlayer!!.start()
            }
        } else {
            //  mediaPlayer.stop()
            //           while (mediaPlayer.isPlaying())
            //          {
            if(mediaPlayer != null)
            {
                mediaPlayer!!.pause()
            }

            //    mediaPlayer.stop()
            //          }
        }
    }

    fun testar(){
  //      var click2 = findViewById<ImageView>(R.id.myImage)
   //     click2.setBackgroundColor(Color.BLACK)

    //    var minText = findViewById<EditText>(R.id.myText)
        var minTextIgen = findViewById<TextView>(R.id.textigen)
        minTextIgen.text = "hej"
    }

}

