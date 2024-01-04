package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener

class MySimpleClass internal constructor(context: Context) : OnInitListener {
    private val tts: TextToSpeech
    private var ttsOk = false

    // The constructor will create a TextToSpeech instance.
    init {
        tts = TextToSpeech(context, this)
    }

    // OnInitListener method to receive the TTS engine status
    override fun onInit(status: Int) {
        ttsOk = status == TextToSpeech.SUCCESS
    }
    // A method to speak something
    // Support older API levels too.
    fun speak(text: String?, override: Boolean) {
        if (ttsOk) {
            if (override) {
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null)
            } else {
                tts.speak(text, TextToSpeech.QUEUE_ADD, null)
            }
        }
    } // Other code goes here...
}