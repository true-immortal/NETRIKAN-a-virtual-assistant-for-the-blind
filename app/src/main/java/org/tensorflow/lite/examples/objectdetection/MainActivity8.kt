package org.tensorflow.lite.examples.objectdetection

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.ContactsContract
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.telephony.SmsManager
import android.util.Log
import android.view.KeyEvent
import android.widget.ImageView
import java.util.*

class MainActivity8 : AppCompatActivity() {

lateinit var imageView:ImageView
lateinit var hlo:String
//var a:MySimpleClass?=null
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
        imageView = findViewById(R.id.message)
     val ll=  intent.extras?.getString("name")
     Log.i("pppl", ll.toString())
        val contacts = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        while (contacts?.moveToNext()!!) {
            val name =
                contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val number =
                contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            if(name.equals(ll,false)){
                Log.i("llllp",name)
             hlo=number
             break
            }
        }
    startSpeechToText(hlo)

         }
        fun sendmessage(hlo: String,message:String) {
                val obj = SmsManager.getDefault()
          try{      obj.sendTextMessage(hlo, null, message, null, null)
            val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(
                    VibrationEffect.createOneShot(500,
                    VibrationEffect.DEFAULT_AMPLITUDE))
            }
            else {
                v.vibrate(500)
            }
        }
        catch (e:Exception){
            val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
            // Vibrate for 500 milliseconds
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(
                    VibrationEffect.createOneShot(500,
                        VibrationEffect.DEFAULT_AMPLITUDE))
            }
            else {
                v.vibrate(500)
                Thread.sleep(500)
                v.vibrate(500)
            }
        }
        }
    private fun startSpeechToText(hlo: String) {
        Thread.sleep(1000)
        val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(bundle: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(v: Float) {}
            override fun onBufferReceived(bytes: ByteArray?) {}
            override fun onEndOfSpeech() {
            }
            override fun onError(i: Int) {}

            override fun onResults(bundle: Bundle) {
                val result = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (result != null) {
                    // result[0] will give the output of speech
                    var mess= result[0].toString()
//                    a!!.speak("message successfully sent",true)
                    sendmessage(hlo,mess)
                   val intentw=Intent(applicationContext,MainActivity2::class.java)
                    startActivity(intentw)
                }
            }
            override fun onPartialResults(bundle: Bundle) {}
            override fun onEvent(i: Int, bundle: Bundle?) {}
        })
        // starts listening ...
        speechRecognizer.startListening(speechRecognizerIntent)
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val intentl= Intent(applicationContext,MainActivity2::class.java)
        when(keyCode){

            KeyEvent.KEYCODE_VOLUME_DOWN->startActivity(intentl)
        }
        return true
    }
}




