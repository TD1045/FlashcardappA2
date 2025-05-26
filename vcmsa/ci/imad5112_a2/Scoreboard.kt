package vcmsa.ci.imad5112_a2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Scoreboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scoreboard)

        val restart = findViewById<Button>(R.id.Restart)
        val done = findViewById<Button>(R.id.Done)
        val Results = findViewById<TextView>(R.id.Results)
            val Score = intent.getIntExtra("Points",0)
            val Total = intent.getIntExtra("Total",5)

        Results.text = "$Score/$Total"

        restart.setOnClickListener {
            val back = Intent(this,MainActivity::class.java)
            startActivity(back)
        }
        done.setOnClickListener {
            finishAffinity()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}