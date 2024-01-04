package org.tensorflow.lite.examples.objectdetection

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ImageView
import androidx.core.app.ActivityCompat

class MainActivity9 : AppCompatActivity() {
    val REQUEST_PHONE_CALL=1
    lateinit var call:ImageView
    lateinit var pname:String
    lateinit var num:String
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        call=findViewById(R.id.calls)
        pname= intent.extras?.getString("pname")!!
//        call.setOnClickListener{
        call()
    }

    @SuppressLint("MissingPermission")
    private fun startCall(a: String) {
        val callIntent=Intent(ACTION_CALL)
        callIntent.data= Uri.parse("tel:"+a)
        startActivity(callIntent)
        this.finish()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==REQUEST_PHONE_CALL)startCall(num)
    }
    @SuppressLint("Range")
    fun call(){

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL)
        }
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
            if(name.equals(pname,false)){
                Log.i("llllp",name)
                num=number
                break
            }
        }
        startCall(num)
    }
}