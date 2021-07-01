package com.home.zzm.apg202107

import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
  private var videoview:VideoView? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    videoview = findViewById(R.id.videoview)
    //对于全屏拉伸操作，主要就是如下代码
    var layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT)
    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
    videoview?.layoutParams = layoutParams
    videoview?.setVideoPath("/sdcard/ZXAdvertisement/奥克斯广场.avi")
    videoview?.setOnPreparedListener { videoview?.start() }
  }
}