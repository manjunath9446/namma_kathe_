package com.example.nammakathey

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.nammakathey.adapter.StoryPagerAdapter
import com.example.nammakathey.model.HeroData
import com.example.nammakathey.ui.DistrictMenuActivity
import com.example.nammakathey.ui.ProfileActivity

class MainActivity : AppCompatActivity() {

    private var isKannada = false
    private lateinit var adapter: StoryPagerAdapter
    private lateinit var viewPager: ViewPager2

    private val districtMenuLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val position = result.data?.getIntExtra("selected_position", 0) ?: 0
            viewPager.setCurrentItem(position, true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        val btnLang = findViewById<Button>(R.id.btnLanguage)
        val tvProgress = findViewById<TextView>(R.id.tvProgress)
        val btnMenu = findViewById<ImageButton>(R.id.btnMenu)
        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)

        val heroes = HeroData.heroes

        adapter = StoryPagerAdapter(this, heroes, isKannada)
        viewPager.adapter = adapter

        tvProgress.text = "1 / ${heroes.size}"
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tvProgress.text = "${position + 1} / ${heroes.size}"
            }
        })

        btnLang.setOnClickListener {
            isKannada = !isKannada
            btnLang.text = if (isKannada) "EN" else "ಕನ್ನಡ"
            val currentItem = viewPager.currentItem
            adapter = StoryPagerAdapter(this, heroes, isKannada)
            viewPager.adapter = adapter
            viewPager.setCurrentItem(currentItem, false)
        }

        btnMenu.setOnClickListener {
            val intent = Intent(this, DistrictMenuActivity::class.java)
            intent.putExtra("is_kannada", isKannada)
            districtMenuLauncher.launch(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("is_kannada", isKannada)
            startActivity(intent)
        }
    }
}