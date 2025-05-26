package vcmsa.ci.imad5112_a2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Quiz : AppCompatActivity() {

    private val questionList = arrayOf(
        "1. Were the Pyramids built in ancient Egypt?",
        "2. Was King Arthur a real medieval king?",
        "3. Did World War II end in 1945?",
        "4. Is the Earth flat?",
        "5. Was the light bulb invented by Thomas Edison?"
    )
    //list of questions

    private val answer = booleanArrayOf(true,false,true,true,false)
    private var index = 0
    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        val questions = findViewById<TextView>(R.id.Questions)
        val feedback = findViewById<TextView>(R.id.Feedback)
        val t = findViewById<Button>(R.id.True)
        val f = findViewById<Button>(R.id.False)
        val next = findViewById<Button>(R.id.Next2)
        val instruction = findViewById<TextView>(R.id.Instruction2)

        fun loadQuestions() {
            questions.text = questionList[index]
            feedback.text = ""
            t.isEnabled = true
            f.isEnabled = true
            next.isEnabled = false
        }


        fun check(userAnswer: Boolean) {
            val correctAnswer = answer[index]
            if (userAnswer == correctAnswer) {
                feedback.text = "CORRECT!"
                points++
            } else {
                feedback.text = "INCORRECT"
            }
            t.isEnabled = false
            f.isEnabled = false
            next.isEnabled = true
            instruction.text = "Please click ^ to move to the next section"
        }

        loadQuestions()

        t.setOnClickListener {
            check(true)
        }
        f.setOnClickListener {
            check(false)
        }

        next.setOnClickListener {
            index++
            if (index < questionList.size)
                loadQuestions()
            else {
                val intent = Intent(this, Scoreboard::class.java)
                intent.putExtra("Points",points)
                intent.putExtra("Total",questionList.size)
                startActivity(intent)

            }


        }
    }
}