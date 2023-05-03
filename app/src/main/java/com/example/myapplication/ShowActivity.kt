package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.adapter.Entry
import com.example.myapplication.adapter.Entryview
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
    lateinit var entry: Entryview
    val datas = mutableListOf<Entryview.ProfileData>()
    private fun initRecycler() {
        entry = Entryview(this)
        binding.rvProfile.adapter = entry
        var len=entry.datas.size


        datas.apply {
            for( i in 0..len){
                var myname=Entry.
                add(Entryview.ProfileData(name = , num={}))
            }
            entry.datas = datas
            entry.notifyDataSetChanged()

        }
    }
}