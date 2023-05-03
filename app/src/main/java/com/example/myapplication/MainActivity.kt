package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.adapter.Entry
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

    lateinit var entry: Entry
    val datas = mutableListOf<Entry.ProfileData>()


    private fun initRecycler() {
        entry = Entry(this)
        binding.rvProfile.adapter = entry


        datas.apply {
            binding.plusID.setOnClickListener{
                add(Entry.ProfileData(name = "", count = 0))
                entry.notifyDataSetChanged()// 앱 화면 업데이트
            }
            entry.datas = datas


        }
    }
}