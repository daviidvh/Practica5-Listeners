package com.example.practica5_listeners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var eT1 = findViewById<EditText>(R.id.EditText1)
        var eT2 = findViewById<EditText>(R.id.EditText2)
        var bot = findViewById<Button>(R.id.button)
       eT1.addTextChangedListener(object : TextWatcher{
           override fun afterTextChanged(s: Editable?) {}
           override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
           override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if ((eT1.length()>0) && (eT2.length()>0))
                   bot.isEnabled=true
               else
                   bot.isEnabled=false
           }
       })


        eT2.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if ((eT1.length()>0) && (eT2.length()>0))
                    bot.isEnabled=true
                else
                    bot.isEnabled=false
            }
        })

    }




}