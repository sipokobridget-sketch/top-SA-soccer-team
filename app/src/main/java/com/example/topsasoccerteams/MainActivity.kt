package com.example.topsasoccerteams

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

class MainActivity: AppCompatActivity() {

    val teams = arrayOf<String>("Man Sundown FC", "Man City", "Man United", "Tottenham")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val teamsTxt = findViewById<TextView>(R.id.textView)

        //reassigning position 0 of the teams array
        teams[0] = "Man Sundown FC :)"

        //variable to hold all teams ready to display
        var teamsDisplay =""
        var counter= 0

        //loop to display top 5 soccer teams
        while (counter < teams.count()) {
            teamsDisplay += "${teams[counter]}\n"
            counter++
        }

        //display top 5 soccer teams in the textview on UI
        teamsTxt.text = Arrays.toString(teams)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}