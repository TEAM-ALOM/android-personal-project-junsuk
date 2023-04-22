package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_main)
        setContentView(binding.root)
        initRecycler()
        binding.editfinish.setOnClickListener {
            val intent = Intent(this, show::class.java)
            startActivity(intent)
        }
    }

    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileAdapter.ProfileData>()


    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)
        binding.rvProfile.adapter = profileAdapter


        datas.apply {
            add(ProfileAdapter.ProfileData(name = "@suksuk0406", count = 5))
            add(ProfileAdapter.ProfileData(name = "@doing.object", count = 6))
            add(ProfileAdapter.ProfileData(name = "@kkamsoon", count = 2))
            add(ProfileAdapter.ProfileData(name = "@sejong", count = 2))
            add(ProfileAdapter.ProfileData(name = "@alom", count = 3))
            add(ProfileAdapter.ProfileData(name = "@android", count = 5))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }
    }
}