package ca.gbc.comp3074.Morgan_Ben.Lab2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var number = 0
    var step = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val outputText = findViewById<TextView>(R.id.outputText)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val stepButton = findViewById<Button>(R.id.stepButton)

        addButton.setOnClickListener {
            number = number + step
            outputText.text = number.toString()
        }

        subtractButton.setOnClickListener {
            number = number - step
            outputText.text = number.toString()
        }

        resetButton.setOnClickListener {
            number = 0
            step = 1
            outputText.text = number.toString()
        }

        stepButton.setOnClickListener {
            step = 2
        }
    }
}