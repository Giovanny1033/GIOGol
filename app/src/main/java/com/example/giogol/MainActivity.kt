package com.example.giogol

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.PrintStream
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  readNames()
        writeNames()*/

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {goToSecondActivity()

        }
    }

   /* fun doClick(view: View){
        //Do something
        println(view)
    }*/



    /*fun readNames(){
        val input = Scanner (resources.openRawResource(R.raw.names))
        while(input.nextLine()){
            println(input.nextLine())
        }
        input.close()
    }*/ //Forma de leer un archivo internamente

    fun writeNames(){
        val output = PrintStream(openFileOutput("Canchas.txt", MODE_APPEND))
        output.println("My favorite cancha")
        output.close()
    }

    /*fun readNames(){
        val input = Scanner(openFileInput("Canchas.txt"))
        println(input.nextLine())
        output.close()
    }*/

    fun goToSecondActivity(){
        val secondIntent = Intent(this, SecondActivity::class.java)
        startActivity(secondIntent)

      /*  val uri = Uri.parse("geo:4.576462800039295, -74.1252105740065") //URI -URL
        val myIntent = Intent(Intent.ACTION_VIEW, uri)
        val myIntent: Intent = Uri.parse("tel: +573176372226").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        val myIntent = Intent(Intent.ACTION_DIAL, data)*/
    }
}