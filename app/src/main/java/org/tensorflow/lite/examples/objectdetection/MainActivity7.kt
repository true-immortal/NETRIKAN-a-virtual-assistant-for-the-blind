package org.tensorflow.lite.examples.objectdetection

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.content.ContentProviderOperation
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.ContactsContract
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.view.KeyEvent
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.collections.ArrayList
class MainActivity7 : AppCompatActivity() {
    private lateinit var contactPermissions:Array<String>
    private val WRITE_CONTACT_PERMISSION_CODE =100

    lateinit var button: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        Log.i("pice","here")
        contactPermissions= arrayOf(Manifest.permission.WRITE_CONTACTS)
        button=findViewById(R.id.button)
        if(isWriteContactPermissionEnabled()){
            Thread.sleep(1500)
            startSpeechToText()
        }
        else{
            requestWriteContactPermission()
        }
    }

    private fun saveContact(ph: Long){
       val fname= intent.extras?.getString("fname")
        val phno=ph
        Log.d(TAG,"saveContact:$fname")
        Log.d(TAG,"saveContact:$phno")

        val cpo= ArrayList<ContentProviderOperation>()
        val rawContactId=cpo.size
       try {
           cpo.add(
               ContentProviderOperation.newInsert(
                   ContactsContract.RawContacts.CONTENT_URI
               )
                   .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                   .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                   .build()
           )
           cpo.add(
               ContentProviderOperation.newInsert(
                   ContactsContract.Data.CONTENT_URI
               )
                   .withValueBackReference(
                       ContactsContract.RawContacts.Data.RAW_CONTACT_ID,
                       rawContactId
                   )
                   .withValue(
                       ContactsContract.RawContacts.Data.MIMETYPE,
                       ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
                   )
                   .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, fname)
                   .build()
           )

           cpo.add(
               ContentProviderOperation.newInsert(
                   ContactsContract.Data.CONTENT_URI
               )
                   .withValueBackReference(
                       ContactsContract.RawContacts.Data.RAW_CONTACT_ID,
                       rawContactId
                   )
                   .withValue(
                       ContactsContract.RawContacts.Data.MIMETYPE,
                       ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE
                   )
                   .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, phno)
                   .withValue(
                       ContactsContract.CommonDataKinds.Phone.TYPE,
                       ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
                   )
                   .build()
           )

       }
       catch (e:Exception){
           Log.i("lol", e.message.toString())
       }
           try{
            contentResolver.applyBatch(ContactsContract.AUTHORITY,cpo)
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
               val intente=Intent(applicationContext,MainActivity2::class.java)
               startActivity(intente)
        }
        catch (e:Exception){
            Log.d("failed to save","FAILED")
            null
        }



    }
    private fun isWriteContactPermissionEnabled():Boolean{
        return ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_CONTACTS)==PackageManager.PERMISSION_GRANTED
    }
    private fun requestWriteContactPermission(){
        ActivityCompat.requestPermissions(this,contactPermissions,WRITE_CONTACT_PERMISSION_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults.isNotEmpty()) {
            if(requestCode==WRITE_CONTACT_PERMISSION_CODE){
                val haveWriteContactPermission=grantResults[0]==PackageManager.PERMISSION_GRANTED
                if(haveWriteContactPermission){
                    startSpeechToText()
                }
                else{
//                    a.speak("permission denied.cannot save contact",true)
                }
            }
        }
    }
    private fun startSpeechToText() {
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
                  var phno= result[0].toString()
                    var str = phno.replace(" ","")
                    saveContact(str.toLong())
                }
            }
            override fun onPartialResults(bundle: Bundle) {}
            override fun onEvent(i: Int, bundle: Bundle?) {}
        })
        // starts listening ...
        speechRecognizer.startListening(speechRecognizerIntent)
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        intent= Intent(applicationContext,MainActivity2::class.java)
        when(keyCode){

            KeyEvent.KEYCODE_VOLUME_DOWN->startActivity(intent)
        }
        return true}

}


