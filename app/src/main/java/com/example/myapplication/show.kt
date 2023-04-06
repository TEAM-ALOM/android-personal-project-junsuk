package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class ProfileAdapter2(private val context: Context) : RecyclerView.Adapter<ProfileAdapter2.ViewHolder>() {

    var datas = mutableListOf<ProfileData2>()

    class ProfileData2(
        val name: String,
        val nums_of_ID: Array<Int>,

        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.result_person,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName: TextView = itemView.findViewById(R.id.ID_show)
        private val txtCount: TextView = itemView.findViewById(R.id.resultnum)


        fun bind(item: ProfileData2) {
            txtName.text = item.name
            txtCount.text = item.nums_of_ID.toString()

        }
    }


}
class show : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycler()
        setContentView(R.layout.activity_show)
        binding.prevbtn.setOnClickListener {
            finish()
        }
    }
    lateinit var profileAdapter: ProfileAdapter2
    val datas = mutableListOf<ProfileAdapter2.ProfileData2>()


    private fun initRecycler() {
        profileAdapter = ProfileAdapter2(this)
        binding.rvProfile.adapter = profileAdapter


        datas.apply {
            add(ProfileAdapter2.ProfileData2(name = "@suksuk0406", nums_of_ID = arrayListOf(1,2,3,4,5)))
            add(ProfileAdapter2.ProfileData2(name = "@doing.object", nums_of_ID =arrayListOf(6,7,8,9,10,11)))
            add(ProfileAdapter2.ProfileData2(name = "@kkamsoon", nums_of_ID =arrayListOf(11,12)))
            add(ProfileAdapter2.ProfileData2(name = "@sejong", nums_of_ID =arrayListOf(13,14)))
            add(ProfileAdapter2.ProfileData2(name = "@alom", nums_of_ID =arrayListOf(15,16,17)))
            add(ProfileAdapter2.ProfileData2(name = "@android", nums_of_ID =arrayListOf(18,19,20,21,22,23)))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }
    }
}