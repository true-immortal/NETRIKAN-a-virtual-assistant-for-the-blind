package org.tensorflow.lite.examples.objectdetection

import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.KeyEvent
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class MainActivity11 : AppCompatActivity() {
    //    private lateinit var inputImageBtn: MaterialButton
    private lateinit var inputImageBtn:ImageView
    private companion object{
        private const val CAMERA_REQEUST_CODE=100
        private const val STORAGE_REQUEST_CODE=101

    }
    var a:MySimpleClass?=null
    private  var imageUri: Uri?=null
    private  lateinit var cameraPermissions: Array<String>
    private  lateinit var storagePermissions:Array<String>
    private lateinit var progressDialog: ProgressDialog
    private lateinit var textRecognizer:TextRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)
        a= MySimpleClass(this)
        inputImageBtn =  findViewById(R.id.inputImageBtn)
        a!!.speak("tap to Pick an image",true)
        cameraPermissions =arrayOf(android.Manifest.permission.CAMERA,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        storagePermissions= arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        progressDialog=ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setCanceledOnTouchOutside(false)
        textRecognizer=TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        inputImageBtn.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }
            if(checkCameraPermissions()){
                pickImageCamera()
            }
            else{
                requestCameraPermission()
            }
                recognizeTextFromImage()
//        }

    }



    private fun recognizeTextFromImage() {
        progressDialog.show()
        try{
            val inputImage=InputImage.fromFilePath(this,imageUri!!)
            val textTaskResult=textRecognizer.process(inputImage)
                .addOnSuccessListener {  text->
                    val recognizedText=text.text
                    Log.i("pppl",recognizedText)
                    if(recognizedText.contains("10 ")||recognizedText.contains("TEN RUPEES",ignoreCase = true))
                    {
                        a!!.speak("TEN RUPEES",true)
                    }
                  else  if(recognizedText.contains("100")||recognizedText.contains("ONE HUNDRED RUPEES",ignoreCase = true))
                    {
                        a!!.speak("HUNDRED RUPEES",true)
                    }
                    else if(recognizedText.contains("20 ")||recognizedText.contains("TWENTY RUPEES",ignoreCase = true))
                {
                    a!!.speak("TWENTY RUPEES",true)
                }
                    else if(recognizedText.contains("50 ")||recognizedText.contains("FIFTY RUPEES",ignoreCase = true))
                {
                    a!!.speak("FIFTY RUPEES",true)
                }
                   else if(recognizedText.contains("500")||recognizedText.contains("FIVE HUNDRED RUPEES",ignoreCase = true))
                    {
                        a!!.speak("FIVE HUNDRED RUPEES",true)
                    }
                    else if(recognizedText.contains("2000")||recognizedText.contains("TWO THOUSAND RUPEES",ignoreCase = true))
                    {
                        a!!.speak("TWO THOUSAND RUPEES",true)
                    }
                    else{
                        a!!.speak("SORRY. I am unable to detect",true)
                    }
                    pickImageCamera()
                    this.finish()
                }
                .addOnFailureListener{e->
                    a!!.speak("failed${e.message}",true)
                }
        }
        catch(e:java.lang.Exception){
            a!!.speak("Tap t capture an image",true)

        }
    }
    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryActivityResultLauncher.launch(intent)
    }
    private val galleryActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
            if (result.resultCode==Activity.RESULT_OK){
                val data=result.data
                imageUri=data!!.data
            }
            else{
                a!!.speak("cancelled..Try Again",true)
            }
        }
    private fun pickImageCamera(){
        val values=ContentValues()
        values.put(MediaStore.Images.Media.TITLE,"sample title")
        values.put(MediaStore.Images.Media.DESCRIPTION,"sample description")
        imageUri=contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
        val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri)
        cameraActivityResultLauncher.launch(intent)
    }

    private val cameraActivityResultLauncher=
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
            if(result.resultCode==Activity.RESULT_OK) {
//                code for vibrating on image select
                recognizeTextFromImage()
            }    }

    private fun checkStoragePermission():Boolean{
        return ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED
    }
    private fun checkCameraPermissions():Boolean{
        val cameraResult=ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED
        val storageResult=ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED

        return cameraResult && storageResult
    }
    private fun requestStoragePermission(){
        ActivityCompat.requestPermissions(this,storagePermissions, STORAGE_REQUEST_CODE)
    }
    private fun requestCameraPermission(){

        ActivityCompat.requestPermissions(this,cameraPermissions, CAMERA_REQEUST_CODE)
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val intenti=Intent(applicationContext,MainActivity2::class.java)
        when(keyCode){

            KeyEvent.KEYCODE_VOLUME_DOWN->   startActivity(intenti)
        }
        return true}

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CAMERA_REQEUST_CODE ->{
                if (grantResults.isNotEmpty()){
                    val cameraAccepted = grantResults[0]==PackageManager.PERMISSION_GRANTED
                    val storageAccepted = grantResults[1]==PackageManager.PERMISSION_GRANTED
                    if (cameraAccepted && storageAccepted){
                        pickImageCamera()
                    } } }

            STORAGE_REQUEST_CODE ->{
                if (grantResults.isNotEmpty()){
                    val storageAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED
                    if (storageAccepted){
                        pickImageGallery()
                    } } } } }
}


















