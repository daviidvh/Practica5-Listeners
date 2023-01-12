package com.example.practica5_listeners

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tV1 = findViewById<TextView>(R.id.TextView1)
        var eT1 = findViewById<EditText>(R.id.EditText1)
        var eT2 = findViewById<EditText>(R.id.EditText2)
        var bot = findViewById<Button>(R.id.button)
       eT1.addTextChangedListener(object : TextWatcher{
           override fun afterTextChanged(s: Editable?) {}
           override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
           override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               bot.isEnabled = (eT1.length()>0) && (eT2.length()>0)
           }
       })


        eT2.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                bot.isEnabled = (eT1.length()>0) && (eT2.length()>0)
            }
        })

        eT1.setOnFocusChangeListener(){x,foco ->
            if(foco)
                tV1.setText(eT1.tag.toString())
        }
        eT2.setOnFocusChangeListener(){x,foco ->
            if(foco)
                tV1.setText(eT2.tag.toString())
        }
        bot.setOnFocusChangeListener(){x,foco ->
            if(foco)
                tV1.setText(bot.tag.toString())
        }

    bot.setOnClickListener {
        agregar(eT1, eT2)
        borrar(eT2)

    }

}

    fun agregar(eT1:EditText, eT2:EditText){

        eT1.setText(eT1.text.toString()+" "+eT2.text.toString())
    }

    fun borrar(eT2:EditText){

        eT2.setText("")

    }
}