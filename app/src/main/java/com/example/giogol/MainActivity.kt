package com.example.giogol

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.giogol.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.io.PrintStream
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    val canchas = arrayListOf<String>("Cancha 1","Cancha 2","Cancha 3","Cancha 4","Cancha 5",) //creamos el arreglo de datos
    var adapter: ArrayAdapter<String>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signOutbtn = findViewById<Button>(R.id.btnlogoff)
        val listaCancha = findViewById<ListView>(R.id.listView)
      /*  readNames()
        writeNames()*/

        adapter = SecondActivity(this, R.layout.activity_second, canchas)
        listaCancha.adapter = adapter

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        listaCancha.setOnItemClickListener{ listview, listitem, index, id ->
            println("item: $listitem, index: $index, id: $id")
            Toast.makeText(this, "Seleccionaste la historia ${canchas[index]}", Toast.LENGTH_SHORT).show()

            //val fourthActivityIntent = Intent(this, FourthActivity::class.java)
            //fourthActivityIntent.putExtra("story", madIds[index])
            //startActivity(fourthActivityIntent)

        }

    }

    private fun signOut(){
        Firebase.auth.signOut()
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
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