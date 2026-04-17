package za.ac.iie.topsoccerteams

import android.os.Bundle
import android.util.Log
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
    // if statement to check if there is limit - if there is a limit. cut the array at that index
    if (limit ==0){
        Log.v("Array values", Arrays.toString(arr))
    }else{
        Log.v("Array Values", Arrays.toString(arr.sliceArray(0..limit - 1)))
    }
}
// looks for longest entry in a string array
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

        //looks for the longest entry in a string array
        fun getLongestString(arr: Array<String>) : String{
            var longestLength = 0
            var longestElement = ""
            for (element in arr) {
                if (element.count() > longestLength) {
                    longestLength =element.count()
                    longestElement = element
                }
            }
            return longestElement
        }

        // call the method to find the longest name in the array
        val longestName = getLongestString(teams)
        Log.v("Longest name", longestName)

        // call the method to log array values
        logArrayValues(teams)
        logArrayValues(teams, 2)

        // get the teams text view
        val teamsTextView = findViewById<TextView>(R.id.teamsTextView)

        //add all the teams to the display string
        var teamsDisplay = ""
        var counter = 0
        while (counter <5) {
            teamsDisplay += "${teams[counter]}\n"
            counter++
        }

        //look for the shortest entry in the string array
        fun getShortestTeam(arr: Array<String>) : String {
            var shortestLength = 0
            var shortestElement = ""
            for (element in arr) {
                if (element.length <shortestLength) {
                    shortestLength = element.length
                    shortestElement = element
                }
            }
            return shortestElement

        }

        // set the shortest team function
        val shortestTeam = getShortestTeam(teams)
        teamsDisplay += "\nShortest name: $shortestTeam"
        teamsTextView.text = teamsDisplay



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