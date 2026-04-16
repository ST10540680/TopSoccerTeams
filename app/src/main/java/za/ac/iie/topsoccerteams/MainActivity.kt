package za.ac.iie.topsoccerteams

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import java.util.Arrays
import kotlin.math.log

//logs the content of an array of strings
fun logArrayValues(arr: Array<String>, limit: Int = 0){
    if (limit ==0){
        Log.v("Array values", Arrays.toString(arr))
    }else{
        Log.v("Array Values", Arr)
    }
}

class MainActivity : AppCompatActivity() {

    // Teams from https://footballdatabase.com/ranking/south-africa/1
    // retrieved on 21 May 2022
    val teams = arrayOf<String>("Mamelodi Sundowns FC",
        "Bidvest Wits",
        "Orlando Pirates",
        "kaizer Chiefs",
        "Cape Town City FC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // get the teams text view
        val teamsTextView = findViewById<TextView>(R.id.teamsTextView)

        //add all the teams to the display string
        var teamsDisplay = ""
        var counter = 0
        while (counter <5) {
            teamsDisplay += "${teams[counter]}\n"
            counter++
        }

        // set the text view's text to the first team
        teamsTextView.text = teams[0]

        // Change the value of element 0
        teams[0] = "Mamelodi Sundowns FC <3"

        // set the text view's text to the string representation of teams
        teamsTextView.text = Arrays.toString(teams)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}