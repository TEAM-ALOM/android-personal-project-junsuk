package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class ProfileAdapter(private val context: Context) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    var datas = mutableListOf<ProfileData>()

    class ProfileData (
        val name : String,
        val count : Int,

    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.person,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName: TextView = itemView.findViewById(R.id.insertID)
        private val txtCount: TextView = itemView.findViewById(R.id.insertnum)


        fun bind(item: ProfileData) {
            txtName.text = item.name
            txtCount.text = item.count.toString()

        }
    }


}

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