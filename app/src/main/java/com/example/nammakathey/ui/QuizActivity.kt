package com.example.nammakathey.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.nammakathey.R
import com.example.nammakathey.data.UserPreferences
import com.example.nammakathey.model.QuizData

class QuizActivity : AppCompatActivity() {

    private lateinit var userPrefs: UserPreferences
    private var currentQuestion = 0
    private var score = 0
    private var selectedOption = -1
    private lateinit var districtKey: String
    private var isKannada = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        userPrefs = UserPreferences(this)
        districtKey = intent.getStringExtra("district_key") ?: ""
        isKannada = intent.getBooleanExtra("is_kannada", false)

        val quiz = QuizData.getQuizForDistrict(districtKey)
        if (quiz == null) {
            finish()
            return
        }

        showQuestion(quiz)
    }

    private fun showQuestion(quiz: com.example.nammakathey.model.DistrictQuiz) {
        val tvQuizTitle = findViewById<TextView>(R.id.tvQuizTitle)
        val tvProgress = findViewById<TextView>(R.id.tvQuizProgress)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val layoutResult = findViewById<LinearLayout>(R.id.layoutResult)

        layoutResult.visibility = View.GONE
        tvQuizTitle.text = "${quiz.districtKey} Quiz"

        fun loadQuestion() {
            if (currentQuestion >= quiz.questions.size) {
                showResult(quiz)
                return
            }

            val q = quiz.questions[currentQuestion]
            tvProgress.text = "Question ${currentQuestion + 1} / ${quiz.questions.size}"
            tvQuestion.text = q.question
            radioGroup.removeAllViews()
            selectedOption = -1
            btnNext.isEnabled = false
            btnNext.alpha = 0.5f

            q.options.forEachIndexed { index, option ->
                val rb = RadioButton(this).apply {
                    text = option
                    id = index
                    textSize = 15f
                    setPadding(16, 20, 16, 20)
                    setTextColor(ContextCompat.getColor(context, R.color.text_dark))
                }
                radioGroup.addView(rb)
            }

            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                selectedOption = checkedId
                btnNext.isEnabled = true
                btnNext.alpha = 1f
            }

            btnNext.text = if (currentQuestion == quiz.questions.size - 1) "Submit" else "Next →"
            btnNext.setOnClickListener {
                if (selectedOption == -1) {
                    Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val q2 = quiz.questions[currentQuestion]
                if (selectedOption == q2.correctIndex) {
                    score++
                    // highlight correct
                    (radioGroup.findViewById<RadioButton>(selectedOption))?.setTextColor(
                        ContextCompat.getColor(this, R.color.correct_green)
                    )
                } else {
                    // highlight wrong & show correct
                    (radioGroup.findViewById<RadioButton>(selectedOption))?.setTextColor(
                        ContextCompat.getColor(this, R.color.wrong_red)
                    )
                    (radioGroup.findViewById<RadioButton>(q2.correctIndex))?.setTextColor(
                        ContextCompat.getColor(this, R.color.correct_green)
                    )
                }
                radioGroup.isEnabled = false
                for (i in 0 until radioGroup.childCount) {
                    (radioGroup.getChildAt(i) as? RadioButton)?.isEnabled = false
                }
                // small delay then move on
                btnNext.postDelayed({
                    currentQuestion++
                    loadQuestion()
                }, 800)
            }
        }

        loadQuestion()
    }

    private fun showResult(quiz: com.example.nammakathey.model.DistrictQuiz) {
        val tvQuizTitle = findViewById<TextView>(R.id.tvQuizTitle)
        val tvProgress = findViewById<TextView>(R.id.tvQuizProgress)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val layoutResult = findViewById<LinearLayout>(R.id.layoutResult)
        val tvResultEmoji = findViewById<TextView>(R.id.tvResultEmoji)
        val tvResultTitle = findViewById<TextView>(R.id.tvResultTitle)
        val tvResultDesc = findViewById<TextView>(R.id.tvResultDesc)
        val tvBadgeAwarded = findViewById<TextView>(R.id.tvBadgeAwarded)
        val btnDone = findViewById<Button>(R.id.btnDone)
        val btnViewProfile = findViewById<Button>(R.id.btnViewProfile)

        // Save score
        userPrefs.saveQuizScore(districtKey, score)

        // Hide quiz UI
        tvProgress.visibility = View.GONE
        tvQuestion.visibility = View.GONE
        radioGroup.visibility = View.GONE
        btnNext.visibility = View.GONE
        layoutResult.visibility = View.VISIBLE

        tvQuizTitle.text = "Result"

        val allCorrect = score == quiz.questions.size

        if (allCorrect) {
            tvResultEmoji.text = quiz.badgeEmoji
            tvResultTitle.text = "Perfect Score! 🎉"
            tvResultDesc.text = "You answered all 3 questions correctly!\nYou've earned the ${quiz.badgeName} badge!"
            tvBadgeAwarded.text = "${quiz.badgeEmoji} ${quiz.badgeName} Badge Earned!"
            tvBadgeAwarded.visibility = View.VISIBLE
            userPrefs.awardBadge(districtKey)
            btnViewProfile.visibility = View.VISIBLE
        } else {
            tvResultEmoji.text = "📖"
            tvResultTitle.text = "You scored $score / ${quiz.questions.size}"
            tvResultDesc.text = "Re-read the story and try again to earn the ${quiz.badgeName} badge!"
            tvBadgeAwarded.visibility = View.GONE
            btnViewProfile.visibility = View.GONE
        }

        btnDone.setOnClickListener { finish() }
        btnViewProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("is_kannada", isKannada)
            startActivity(intent)
            finish()
        }
    }
}