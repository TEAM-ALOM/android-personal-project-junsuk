package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityShowBinding

class ShowActivity : AppCompatActivity() {
    private val binding: ActivityShowBinding by lazy {
        ActivityShowBinding.inflate(layoutInflater)
    }// 바인딩->UI 요소에 대한 접근을 편하게 할 수 있음

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycler()
        binding.prevbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.nextbtn.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
    }
    lateinit var profileOutAdapter: ProfileOutAdapter
    val datas = mutableListOf<ProfileOutAdapter.ProfileData>()
    private fun initRecycler() {
        profileOutAdapter = ProfileOutAdapter(this)
        binding.rvProfile.adapter = profileOutAdapter


        datas.apply {
            add(ProfileOutAdapter.ProfileData(name = "@suksuk0406", count = 5))
            add(ProfileOutAdapter.ProfileData(name = "@doing.object", count = 6))
            add(ProfileOutAdapter.ProfileData(name = "@kkamsoon", count = 2))
            add(ProfileOutAdapter.ProfileData(name = "@sejong", count = 2))
            add(ProfileOutAdapter.ProfileData(name = "@alom", count = 3))
            add(ProfileOutAdapter.ProfileData(name = "@android", count = 5))

            profileOutAdapter.datas = datas
            profileOutAdapter.notifyDataSetChanged()

        }
    }
}