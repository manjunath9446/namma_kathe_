package com.example.nammakathey.ui

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nammakathey.R
import com.example.nammakathey.data.UserPreferences
import com.example.nammakathey.model.QuizData

class ProfileActivity : AppCompatActivity() {

    private lateinit var userPrefs: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        userPrefs = UserPreferences(this)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val tvProfileName = findViewById<TextView>(R.id.tvProfileName)
        val btnEditName = findViewById<ImageButton>(R.id.btnEditName)
        val tvBadgeCount = findViewById<TextView>(R.id.tvBadgeCount)
        val tvBadgeSubtitle = findViewById<TextView>(R.id.tvBadgeSubtitle)
        val rvBadges = findViewById<RecyclerView>(R.id.rvBadges)
        val tvProgressBar = findViewById<TextView>(R.id.tvProgressBar)

        btnBack.setOnClickListener { finish() }

        // Name
        fun refreshName() {
            val name = userPrefs.userName
            tvProfileName.text = if (name.isBlank()) "Explorer" else name
        }
        refreshName()

        btnEditName.setOnClickListener {
            val editText = EditText(this).apply {
                inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
                hint = "Enter your name"
                setText(userPrefs.userName)
                setPadding(48, 32, 48, 32)
            }
            AlertDialog.Builder(this)
                .setTitle("What's your name?")
                .setView(editText)
                .setPositiveButton("Save") { _, _ ->
                    val name = editText.text.toString().trim()
                    if (name.isNotBlank()) {
                        userPrefs.userName = name
                        refreshName()
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
        }

        // Badge count
        val allDistricts = QuizData.quizzes.map { it.districtKey }
        val totalBadges = userPrefs.getTotalBadges(allDistricts)
        val totalDistricts = allDistricts.size
        tvBadgeCount.text = "$totalBadges"
        tvBadgeSubtitle.text = "of $totalDistricts Heritage Badges Earned"

        // Progress text
        val percent = (totalBadges * 100) / totalDistricts
        tvProgressBar.text = when {
            percent == 100 -> "🏆 Karnataka Heritage Master!"
            percent >= 75 -> "🌟 Heritage Champion — $percent% complete"
            percent >= 50 -> "🎯 Half-way Explorer — $percent% complete"
            percent >= 25 -> "🚀 Rising Explorer — $percent% complete"
            percent > 0 -> "🌱 Just Getting Started — $percent% complete"
            else -> "Start quizzes to earn your first badge!"
        }

        // Badge grid
        rvBadges.layoutManager = GridLayoutManager(this, 3)
        rvBadges.adapter = BadgeAdapter(QuizData.quizzes, userPrefs)
    }
}

class BadgeAdapter(
    private val quizzes: List<com.example.nammakathey.model.DistrictQuiz>,
    private val userPrefs: UserPreferences
) : RecyclerView.Adapter<BadgeAdapter.BadgeVH>() {

    inner class BadgeVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvEmoji: TextView = itemView.findViewById(R.id.tvBadgeEmoji)
        val tvName: TextView = itemView.findViewById(R.id.tvBadgeName)
        val tvDistrict: TextView = itemView.findViewById(R.id.tvBadgeDistrict)
        val cardBg: View = itemView.findViewById(R.id.badgeCardBg)
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): BadgeVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_badge, parent, false)
        return BadgeVH(view)
    }

    override fun getItemCount() = quizzes.size

    override fun onBindViewHolder(holder: BadgeVH, position: Int) {
        val quiz = quizzes[position]
        val earned = userPrefs.hasBadge(quiz.districtKey)

        if (earned) {
            holder.tvEmoji.text = quiz.badgeEmoji
            holder.tvEmoji.alpha = 1f
            holder.tvName.text = quiz.badgeName
            holder.tvDistrict.text = quiz.districtKey
            holder.tvDistrict.visibility = View.VISIBLE
            holder.cardBg.setBackgroundResource(R.drawable.bg_badge_earned)
        } else {
            holder.tvEmoji.text = "🔒"
            holder.tvEmoji.alpha = 0.4f
            holder.tvName.text = quiz.badgeName
            holder.tvDistrict.visibility = View.GONE
            holder.cardBg.setBackgroundResource(R.drawable.bg_badge_locked)
        }
    }
}