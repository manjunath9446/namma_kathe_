package com.example.nammakathey.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.nammakathey.R
import com.example.nammakathey.data.UserPreferences
import com.example.nammakathey.model.Hero
import com.example.nammakathey.model.QuizData

class StoryFragment : Fragment() {

    companion object {
        private const val ARG_DISTRICT = "district"
        private const val ARG_DISTRICT_KN = "district_kn"
        private const val ARG_HERO = "hero"
        private const val ARG_HERO_KN = "hero_kn"
        private const val ARG_STORY = "story"
        private const val ARG_STORY_KN = "story_kn"
        private const val ARG_ILLUSTRATION = "illustration"
        private const val ARG_IS_KANNADA = "is_kannada"

        fun newInstance(hero: Hero, isKannada: Boolean): StoryFragment {
            val fragment = StoryFragment()
            val args = Bundle()
            args.putString(ARG_DISTRICT, hero.district)
            args.putString(ARG_DISTRICT_KN, hero.districtKn)
            args.putString(ARG_HERO, hero.hero)
            args.putString(ARG_HERO_KN, hero.heroKn)
            args.putString(ARG_STORY, hero.story)
            args.putString(ARG_STORY_KN, hero.storyKn)
            args.putString(ARG_ILLUSTRATION, hero.illustrationType)
            args.putBoolean(ARG_IS_KANNADA, isKannada)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = requireArguments()
        val isKannada = args.getBoolean(ARG_IS_KANNADA)
        val illustrationType = args.getString(ARG_ILLUSTRATION, "temple")
        val districtKey = args.getString(ARG_DISTRICT, "")

        val tvDistrict = view.findViewById<TextView>(R.id.tvDistrict)
        val tvHero = view.findViewById<TextView>(R.id.tvHero)
        val tvStory = view.findViewById<TextView>(R.id.tvStory)
        val ivIllustration = view.findViewById<ImageView>(R.id.ivIllustration)
        val btnQuiz = view.findViewById<Button>(R.id.btnTakeQuiz)
        val tvBadgeEarned = view.findViewById<TextView>(R.id.tvBadgeEarned)

        tvDistrict.text = if (isKannada) args.getString(ARG_DISTRICT_KN) else districtKey
        tvHero.text = if (isKannada) args.getString(ARG_HERO_KN) else args.getString(ARG_HERO)
        tvStory.text = if (isKannada) args.getString(ARG_STORY_KN) else args.getString(ARG_STORY)

        val drawableRes = when (illustrationType) {
            "temple" -> R.drawable.ic_temple
            "fort" -> R.drawable.ic_fort
            "warrior" -> R.drawable.ic_warrior
            "weave" -> R.drawable.ic_weave
            "dam" -> R.drawable.ic_dam
            "craft" -> R.drawable.ic_craft
            "forest" -> R.drawable.ic_forest
            "hill" -> R.drawable.ic_hill
            "coffee" -> R.drawable.ic_coffee
            "dance" -> R.drawable.ic_dance
            "flag" -> R.drawable.ic_flag
            "music" -> R.drawable.ic_music
            "mountain" -> R.drawable.ic_mountain
            "sea" -> R.drawable.ic_sea
            else -> R.drawable.ic_temple
        }
        ivIllustration.setImageResource(drawableRes)

        val userPrefs = UserPreferences(requireContext())
        val quiz = QuizData.getQuizForDistrict(districtKey)

        if (quiz != null) {
            refreshQuizState(view, districtKey, quiz, isKannada)
            btnQuiz.setOnClickListener {
                val intent = Intent(requireContext(), QuizActivity::class.java)
                intent.putExtra("district_key", districtKey)
                intent.putExtra("is_kannada", isKannada)
                startActivity(intent)
            }
        } else {
            btnQuiz.visibility = View.GONE
            tvBadgeEarned.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        val districtKey = arguments?.getString(ARG_DISTRICT, "") ?: return
        val view = view ?: return
        val isKannada = arguments?.getBoolean(ARG_IS_KANNADA, false) ?: false
        val quiz = QuizData.getQuizForDistrict(districtKey) ?: return
        refreshQuizState(view, districtKey, quiz, isKannada)
    }

    private fun refreshQuizState(view: View, districtKey: String, quiz: com.example.nammakathey.model.DistrictQuiz, isKannada: Boolean) {
        val btnQuiz = view.findViewById<Button>(R.id.btnTakeQuiz) ?: return
        val tvBadgeEarned = view.findViewById<TextView>(R.id.tvBadgeEarned) ?: return
        val userPrefs = UserPreferences(requireContext())
        val hasBadge = userPrefs.hasBadge(districtKey)
        val hasAttempted = userPrefs.hasAttemptedQuiz(districtKey)

        if (hasBadge) {
            tvBadgeEarned.visibility = View.VISIBLE
            tvBadgeEarned.text = if (isKannada)
                "${quiz.badgeEmoji} ${quiz.badgeName} ಬ್ಯಾಡ್ಜ್ ಗಳಿಸಲಾಗಿದೆ!"
            else
                "${quiz.badgeEmoji} ${quiz.badgeName} Badge Earned!"
            btnQuiz.text = if (isKannada) "🔄 ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ" else "🔄 Retake Quiz"
        } else {
            tvBadgeEarned.visibility = View.GONE
            btnQuiz.text = when {
                isKannada && hasAttempted -> "🔄 ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ"
                isKannada -> "📝 ರಸಪ್ರಶ್ನೆ ತೆಗೆದುಕೊಳ್ಳಿ"
                hasAttempted -> "🔄 Try Again"
                else -> "📝 Take Quiz"
            }
        }
    }
}