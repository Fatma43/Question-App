package com.example.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.*
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.second.*
import java.lang.Exception
import java.util.*

class second : AppCompatActivity() {
    var index:Int?=null
    var val_ques:Array<String >?=null
    var val_ans:Array<String >?=null
    var def="Press the button to answer..."
    var speatch:TextToSpeech?=null
    var num:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
       speatch= TextToSpeech(this, object : TextToSpeech.OnInitListener{
           override fun onInit(p0: Int) {
             num=speatch!!.setLanguage(Locale.ENGLISH)
           }

       })
        val_ans=resources.getStringArray(R.array.ans)
        val_ques=resources.getStringArray(R.array.ques)
        index=0
        tv_ans.text=def
        tv_qu.text="${val_ques!![index!!]}"
        tv_xx.text="${index!!+1}/"
        tv_yy.text="${val_ques!!.size}"

    }
    fun showAction(v: View?)
    {

       when(v?.id)
        {
            R.id.back -> {
                try{
                tv_ans.text=def
                index = index!! - 1
                tv_qu.text = "${val_ques!![index!!]}"
                tv_xx.text="${(index!!+1).toString()}/"
            }
                catch(ex:Exception){
                    index=val_ques!!.size-1
                    tv_ans.text="${val_ans!![index!!]}"
                    tv_xx.text="${(index!!+1).toString()}/"
                }
            }

    R.id.ans -> {
        tv_ans.text="${val_ans!![index!!]}"
    }
    R.id.next -> {
        try{
        tv_ans.text=def
        index=index!! + 1
        tv_qu.text="${val_ques!![index!!]}"
        tv_xx.text="${(index!!+1).toString()}/"}
           catch(ex:Exception){
               index=0
               tv_ans.text="${val_ans!![index!!]}"
               tv_xx.text="1/"
           }
    }
           R.id.btn_voice ->{
               if(num==TextToSpeech.LANG_NOT_SUPPORTED||num==TextToSpeech.LANG_MISSING_DATA)
               {
                   Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
               }
               else
               {
                   speatch!!.speak(tv_qu.text,TextToSpeech.QUEUE_FLUSH,null,null)
               }
           }
}
    }
}
