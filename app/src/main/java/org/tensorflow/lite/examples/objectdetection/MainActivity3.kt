package org.tensorflow.lite.examples.objectdetection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.KeyEvent
import android.widget.ImageView
import java.util.*

// Extending MainActivity TextToSpeech.OnInitListener class
class MainActivity3 : AppCompatActivity(),TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var btnSpeak: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        btnSpeak = findViewById(R.id.imageView)

//        etSpeak.setText(lol)
        btnSpeak!!.isEnabled = false

        // TextToSpeech(Context: this, OnInitListener: this)
        tts = TextToSpeech(this, this)

        btnSpeak!!.setOnClickListener { speakOut() }

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language not supported!")
            } else {
                btnSpeak!!.isEnabled = true
            }
        }
    }
    private fun speakOut() {
        val lol=intent.extras?.getString("lol")
        tts!!.speak(lol, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    public override fun onDestroy() {
        // Shutdown TTS when
        // activity is destroyed
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        intent= Intent(applicationContext,MainActivity2::class.java)
        when(keyCode){

            KeyEvent.KEYCODE_VOLUME_DOWN->this.finish()
        }
        return true}
}
