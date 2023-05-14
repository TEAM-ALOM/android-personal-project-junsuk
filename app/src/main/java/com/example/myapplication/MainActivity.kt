package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.adapter.Entry
import com.example.myapplication.adapter.Person
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main){
    val datas = mutableListOf<Person>()
    private lateinit var entry: Entry


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //initRecycler()
        datas.apply {
            add(Person(name = "ID", count =0))
        }
        datas.apply {
            binding.plusID.setOnClickListener{//인원 추가 버튼 누르면
                add(Person(name = "", count = 0))// Entry 프로필 한명 추가
                entry.notifyDataSetChanged()// 앱 화면 업데이트
            }
            entry.datas = datas


        }
        binding.editfinish.setOnClickListener {
            val intent = Intent(this, ShowActivity::class.java)
            startActivity(intent)
        }
    }
/*
    private fun initRecycler() {

    }

 */
}