package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }// 바인딩->UI 요소에 대한 접근을 편하게 할 수 있음

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_main)
        setContentView(binding.root)
        initRecycler()
        binding.editfinish.setOnClickListener {
            val intent = Intent(this, ShowActivity::class.java)
            startActivity(intent)
        }
    }

    lateinit var profileInAdapter: ProfileInAdapter
    val datas = mutableListOf<ProfileInAdapter.ProfileData>()


    private fun initRecycler() {
        profileInAdapter = ProfileInAdapter(this)
        binding.rvProfile.adapter = profileInAdapter


        datas.apply {
            add(ProfileInAdapter.ProfileData(name = "@suksuk0406", count = 5))
            add(ProfileInAdapter.ProfileData(name = "@doing.object", count = 6))
            add(ProfileInAdapter.ProfileData(name = "@kkamsoon", count = 2))
            add(ProfileInAdapter.ProfileData(name = "@sejong", count = 2))
            add(ProfileInAdapter.ProfileData(name = "@alom", count = 3))
            add(ProfileInAdapter.ProfileData(name = "@android", count = 5))

            profileInAdapter.datas = datas
            profileInAdapter.notifyDataSetChanged()

        }
    }
}