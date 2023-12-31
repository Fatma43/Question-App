package com.example.question

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import kotlinx.android.synthetic.main.front.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.front)
        var question=findViewById<Button>(R.id.question)
        question.setOnClickListener(){
            var i= Intent(this,second::class.java)
            startActivity(i)
        }
        rateapp.setOnClickListener{
         try{
             var uri:Uri= Uri.parse("market://details?id $packageName")
             var i=Intent(Intent.ACTION_VIEW)
             i.data=uri
             startActivity(i)
         }catch(ex:Exception) {
             var uri:Uri= Uri.parse("http://play.google.com/store/apps/details?id $packageName")
             var i=Intent(Intent.ACTION_VIEW)
             i.data=uri
             startActivity(i)
         }
        }
    }
}