package app.wakayama.tama.sound2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ドラムのサウンドファイルを読み込んで、プレイヤーを作る
        val drumSound = MediaPlayer.create(this,R.raw.drum_sound)

        drumImage.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                //ドラムが鳴っている画像に切替える
                drumImage.setImageResource(R.drawable.drum_playing_image)
                //ドラムの音を巻き戻す
                drumSound.seekTo(0)

                //ドラムの音を再生する
                drumSound.start()
            }
            else if (event.action == MotionEvent.ACTION_UP){
                drumImage.setImageResource(R.drawable.drum_image)
            }

            true
        }
    }
}