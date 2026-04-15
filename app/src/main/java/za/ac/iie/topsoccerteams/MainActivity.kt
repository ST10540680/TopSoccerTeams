package za.ac.iie.topsoccerteams

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Teams from https://footballdatabase.com/ranking/south-africa/1
    //retrieved on 21 May 2022
    val teams = arrayOf<String>("Mamelodi Sundowns FC",
        "Bidvest Wits",
        "Orlando Pirates",
        "kaizer Chiefs",
        "Cape Town City FC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //get the teams text view
        val teamsTextView = findViewById<TextView>(R.id.teamsTextView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}