package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        intent?.extras?.let{ it ->


            val temp1 = it.getString("key1")
            val temp2 = it.getString("key2")

            val button2 = findViewById<Button>(R.id.button2)
            button2.setOnClickListener {

                val edittext3 = findViewById<EditText>(R.id.edittext3).text
                val edittext4 = findViewById<EditText>(R.id.edittext4).text
                val bundle = Bundle()

                bundle.putString("key1",temp1)
                bundle.putString("key2",temp2)
                bundle.putString("key3",edittext3.toString())
                bundle.putString("key4",edittext4.toString())

                val intent = Intent().putExtras(bundle)
                setResult(Activity.RESULT_OK,intent.putExtras(bundle))
                finish()
            }
        }

    }
}