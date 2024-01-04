package org.tensorflow.lite.examples.objectdetection

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*
import kotlin.system.exitProcess

class MainActivity2 : AppCompatActivity() {
    var loo:String?=null
    lateinit var wifiManager: WifiManager
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a=MySimpleClass(this)
        val   intent2 = Intent(applicationContext, MainActivity7::class.java)
        val   intent3 = Intent(applicationContext, MainActivity8::class.java)
        setContentView(R.layout.activity_main2)



//        ForegroundService.startService(this, "Foreground Service is running...")
        intent= Intent(applicationContext,MainActivity::class.java)
        val intenti= Intent(/* packageContext = */ applicationContext, /* cls = */MainActivity5::class.java)
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED)
        {
            checkPermissions()
        }
        val micBtn: ImageView? = findViewById(R.id.button)
        val speechRecognizer: SpeechRecognizer? = SpeechRecognizer.createSpeechRecognizer(this)
        val speechRecognizerIntent=Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault())
//        a.speak("WELCOME TO NETRIKAN. A VIRTUAL ASSISTANT. TAP COMMAND LINE TO KNOW MORE.",true)
//        val ll=  intent.extras?.getString("contactnull")

        speechRecognizer!!.setRecognitionListener(object :RecognitionListener{
            override fun onReadyForSpeech(params: Bundle?) {
                a.speak("Listening",override = true)

            }

            override fun onBeginningOfSpeech() {}

            override fun onRmsChanged(rmsdB: Float) {}

            override fun onBufferReceived(buffer: ByteArray?) {}

            override fun onEndOfSpeech() {}

            override fun onError(error: Int) {
                a.speak("Sorry. Try Again",override = true)
            }



            override fun onResults(bundle: Bundle?) {

                micBtn!!.setImageResource(R.drawable.ic_mic_offs)
                val data=bundle!!.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)

                if (data!![0].contains("object",ignoreCase = true)){
//                    a.speak("Opening Object Detection",true)
                    loo=(data.toString()).substringAfter("object ")
                    val lopol=loo.toString()
                    Log.i("lopol", lopol)
                    a.speak("Opening Object Detection",false)
                    startActivity(intent)

                }

                else if(data[0]=="hello"||data[0]=="hi"){
                a.speak("Hi. I am Nethrikan .Your virtual assistant",false)
                a.speak("use information to know more about the application",false)
                }
                else if (data[0]=="battery"){
                    val bm = applicationContext.getSystemService(BATTERY_SERVICE) as BatteryManager
                    // Get the battery percentage and store it in a INT variable
                    val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
                    val batt=batLevel.toString()
                    a.speak("your Phone Is At "+batt+"percentage",override = true)
                }
                else if(data[0]=="currency"){
                    a.speak("OPENING CURRENCY DETECTION",true)
                    Thread.sleep(1000)
                  val intent11=Intent(applicationContext,MainActivity11::class.java)
                  startActivity(intent11)
                }
                else if(data[0]=="my location"){
                    getLocation(a)
                }
                else if(data[0]=="call"){
                    a.speak("read the number you wish to call",override = true)
                    Thread.sleep(1000)
                    val intentcall=Intent(applicationContext,MainActivity10::class.java)
                    startActivity(intentcall)
                }
                else if(data[0].contains("call ",ignoreCase = true)){
                    val pname=data[0].substringAfter("call ")
                    a.speak("calling $pname",override = true)
                    Thread.sleep(1000)
                    val intentcall=Intent(applicationContext,MainActivity9::class.java)
                    intentcall.putExtra("pname", pname)
                        startActivity(intentcall)

                }
                else if(data[0]=="read image"){
                    a.speak("opening screen reader.Tap to open camera",override = true)
                    startActivity(intenti)
                }
                else if(data[0]=="information"){
                    Thread.sleep(500)
                    a.speak("object. Used to Detect Objects using Camera",false)
                    a.speak("Battery.  Obtains battery percentage",false)
                    a.speak("read image. Reads the text captured by the camera",false)
                    a.speak("time. Provides current time.",false)
                    a.speak("Add Contact . adds contact to your phone",false)
                    a.speak("Date. Provide date of the year.",false)
                    a.speak("call. Calls the specified contact",false)
                    a.speak("my Location.provides your current location",false)
                    a.speak("Currency. detects captured currency value",false)
                    a.speak("send message. Sends message to the specified contact name",false)
                    a.speak("CLose or exit. CLOSES THE APPLICATION",false)
                    a.speak("developer information.provides information about Netrikan developers",false)
                    a.speak("information.provides a list of commands",false)
                }
                else if(data[0].contains("send message to ")||data[0].contains("message ")){
                    val ll=data[0].substringAfter("to ")
                    intent3.putExtra("name",ll)
                    a.speak("Read the message you wish to add",false)
                    Thread.sleep(1000)
                    startActivity(intent3)
                }
                else if(data[0]=="time"){
                    val c = Calendar.getInstance()
                    var hour = c.get(Calendar.HOUR_OF_DAY)
                    val minute = c.get(Calendar.MINUTE)
                    if(hour<=12){
                    a.speak("CURRENTLY THE TIME IS $hour $minute A.M.",true)
                }
                else
                    {
                        hour -= 12
                        a.speak("CURRENTLY THE TIME IS $hour $minute P.M.",true)
                    }}
                else if(data[0]=="date"){
                    val c=Calendar.getInstance()
                    val year = c.get(Calendar.YEAR)
                    val day = c.get(Calendar.DAY_OF_MONTH)
                    a.speak("TODAY IS $day of NOVEMBER $year",override = true)
                }
                else if(data[0].contains("Add Contact",ignoreCase = true)){
                    intent2.putExtra("fname",data[0].substringAfter("contact "))
                   a.speak("Read the mobile number you wish to add",false)
                    startActivity(intent2)
                }

                else if(data[0].contains("internet",true)){
                    val wifi = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
    wifi.isWifiEnabled =true
                    }
                else if(data[0].contains("developer information",ignoreCase = true)){
                    a.speak("Netrikan is an android application developed by third year computer engineering students of government polytechnic, Srikakulam.",false)
                    a.speak("Developers K sri satya and D Venkateswara rao.Guided by dr.b Drakshayaini",false)
                }
                else if(data[0].contains("calculate ",true)){
                    Log.i("ppp",data[0])

                }
                else if(data[0]=="close"||data[0]=="exit"){
                    a.speak("closing Nethrikan.Have a good day.",false)
                    Thread.sleep(3000)
                lol()
                    exitProcess(0)
                }
                else
                {
                    a.speak("Sorry..I didn't quite understand",override = true)
                }
            }
            override fun onPartialResults(partialResults: Bundle?) {
            }
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
        micBtn!!.setOnTouchListener { _, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_UP){
                speechRecognizer.stopListening()
            }
            if(motionEvent.action==MotionEvent.ACTION_DOWN){
                micBtn.setImageResource(R.drawable.micon)
                speechRecognizer.startListening(
                    speechRecognizerIntent
                )
            }
            false
        }
    }
    fun enableWifi(view: View) {
        wifiManager.isWifiEnabled = true
    }
    fun disableWifi(view: View) {
        wifiManager.isWifiEnabled = false
    }
    //    override fun onDestroy() {
//        super.onDestroy()
//        SpeechRecognizer!!.destroy()
//    }

    fun lol(){
//        ForegroundService.stopService(this)
    }
    companion object{
        const val RecordAudioRequestCode=1
    }


    private fun checkPermissions() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                RecordAudioRequestCode,
            )
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== RecordAudioRequestCode
            && grantResults.isNotEmpty()){
            Toast.makeText(this,"permission granted", Toast.LENGTH_SHORT).show()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
    }


    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }
    @SuppressLint("MissingPermission", "SetTextI18n")
    private fun getLocation(a: MySimpleClass) {
//        if (checkPermissionss()) {
        if (isLocationEnabled()) {
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
            mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                val location: Location? = task.result
                Log.i("loc", location.toString())
                if (location != null) {
                    val geocoder = Geocoder(this, Locale.getDefault())
                    val list: List<Address> =
                        geocoder.getFromLocation(location.latitude, location.longitude, 1)
                    val loc=list[0].getAddressLine(0).substringAfter(", ")
                    a.speak("you are currently at ${list[0].getAddressLine(0).substringBefore(", ")} ",false)
                    a.speak(loc, false)
                }
            }
        } else {
            a.speak("Your location services are turned off", false)
        }

    }


}