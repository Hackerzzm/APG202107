package com.home.zzm.apg202107

import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
  private var videoview:VideoView? = null
  val path = arrayOf("/sdcard/ZXAdvertisement/奥克斯广场.avi","/sdcard/ZXAdvertisement/拜博口腔.avi")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    var index = 0
    videoview = findViewById(R.id.videoview)
    //对于全屏拉伸操作，主要就是如下代码
    var layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT)
    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
    videoview?.layoutParams = layoutParams
    playv(index)
    videoview?.setOnPreparedListener { videoview?.start() }
    videoview?.setOnCompletionListener {
      index ++
      if (index == 2){
        index = 0
      }
      playv(index)
    }
  }

  fun playv(index:Int){
    videoview?.setVideoPath(path[index])
  }
}