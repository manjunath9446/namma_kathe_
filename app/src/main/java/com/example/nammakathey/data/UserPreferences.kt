package com.example.nammakathey.data

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("namma_kathe_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_BADGES_PREFIX = "badge_"
        private const val KEY_QUIZ_SCORE_PREFIX = "quiz_score_"
    }

    var userName: String
        get() = prefs.getString(KEY_USER_NAME, "") ?: ""
        set(value) = prefs.edit().putString(KEY_USER_NAME, value).apply()

    fun hasBadge(districtKey: String): Boolean {
        return prefs.getBoolean(KEY_BADGES_PREFIX + districtKey, false)
    }

    fun awardBadge(districtKey: String) {
        prefs.edit().putBoolean(KEY_BADGES_PREFIX + districtKey, true).apply()
    }

    fun saveQuizScore(districtKey: String, score: Int) {
        prefs.edit().putInt(KEY_QUIZ_SCORE_PREFIX + districtKey, score).apply()
    }

    fun getQuizScore(districtKey: String): Int {
        return prefs.getInt(KEY_QUIZ_SCORE_PREFIX + districtKey, -1)
    }

    fun getTotalBadges(allDistricts: List<String>): Int {
        return allDistricts.count { hasBadge(it) }
    }

    fun hasAttemptedQuiz(districtKey: String): Boolean {
        return prefs.contains(KEY_QUIZ_SCORE_PREFIX + districtKey)
    }
}