package com.example.nammakathey.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.nammakathey.R
import com.example.nammakathey.data.UserPreferences
import com.example.nammakathey.model.HeroData
import com.example.nammakathey.model.QuizData

class DistrictMenuActivity : AppCompatActivity() {

    private lateinit var userPrefs: UserPreferences
    private lateinit var adapter: DistrictListAdapter
    private var isKannada = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_district_menu)

        userPrefs = UserPreferences(this)
        isKannada = intent.getBooleanExtra("is_kannada", false)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val etSearch = findViewById<EditText>(R.id.etSearch)
        val rvDistricts = findViewById<RecyclerView>(R.id.rvDistricts)

        btnBack.setOnClickListener { finish() }

        val heroes = HeroData.heroes
        adapter = DistrictListAdapter(heroes.toMutableList(), isKannada, userPrefs) { position ->
            val result = Intent()
            result.putExtra("selected_position", position)
            setResult(RESULT_OK, result)
            finish()
        }

        rvDistricts.layoutManager = LinearLayoutManager(this)
        rvDistricts.adapter = adapter

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().lowercase()
                val filtered = heroes.filter {
                    it.district.lowercase().contains(query) ||
                            it.districtKn.contains(query) ||
                            it.hero.lowercase().contains(query)
                }
                adapter.updateList(filtered)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}

class DistrictListAdapter(
    private var items: MutableList<com.example.nammakathey.model.Hero>,
    private val isKannada: Boolean,
    private val userPrefs: UserPreferences,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<DistrictListAdapter.VH>() {

    // Keep original list for position lookup
    private val originalHeroes = HeroData.heroes

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvNumber: TextView = view.findViewById(R.id.tvDistrictNumber)
        val tvDistrict: TextView = view.findViewById(R.id.tvDistrictName)
        val tvHero: TextView = view.findViewById(R.id.tvHeroName)
        val tvBadge: TextView = view.findViewById(R.id.tvBadgeStatus)
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_district, parent, false)
        return VH(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val hero = items[position]
        val originalIndex = originalHeroes.indexOfFirst { it.district == hero.district }

        holder.tvNumber.text = "${originalIndex + 1}"
        holder.tvDistrict.text = if (isKannada) hero.districtKn else hero.district
        holder.tvHero.text = if (isKannada) hero.heroKn else hero.hero

        val hasBadge = userPrefs.hasBadge(hero.district)
        val quiz = QuizData.getQuizForDistrict(hero.district)
        holder.tvBadge.text = when {
            hasBadge -> "${quiz?.badgeEmoji ?: "🏅"}"
            userPrefs.hasAttemptedQuiz(hero.district) -> "📖"
            else -> ""
        }

        holder.itemView.setOnClickListener {
            onItemClick(originalIndex)
        }
    }

    fun updateList(newList: List<com.example.nammakathey.model.Hero>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}