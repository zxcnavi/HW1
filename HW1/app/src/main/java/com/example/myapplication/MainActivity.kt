package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            val bundle = Bundle()
            val editText1 = findViewById<EditText>(R.id.edittext1).text
            val editText2 = findViewById<EditText>(R.id.edittext2).text

            bundle.putString("key1", editText1.toString())
            bundle.putString("key2", editText2.toString())
            intent.putExtras(bundle)
            startActivityForResult(intent, 1)

            findViewById<EditText>(R.id.edittext1).visibility = View.INVISIBLE
            findViewById<EditText>(R.id.edittext2).visibility = View.INVISIBLE
        }
    }




        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            data?.extras?.let {
                if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                    findViewById<TextView>(R.id.textView).text =
                        "姓名: ${it.getString("key1")}\n\n" + "電話: ${it.getString("key2")}\n\n" +
                                "大小: ${it.getString("key3")}\n\n" + "顏色: ${it.getString("key4")}\n\n"
                }
            }

        }
}