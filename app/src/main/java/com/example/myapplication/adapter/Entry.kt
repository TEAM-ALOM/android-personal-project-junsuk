package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.PersonBinding

class Entry(private val datas : ArrayList<Person>): RecyclerView.Adapter<Entry.ViewHolder>() {
    inner class ViewHolder(private val binding: PersonBinding): RecyclerView.ViewHolder(binding.root) {
        private val insertID : EditText=binding.insertID
        private val insertnum : EditText=binding.insertnum

        fun bind(item:Person) {//EditText 형식과 데이터를 바인딩해주어야 하는데 어떤 형식으로 해야하는지 모르겠습니다ㅠㅠ
            binding.insertID.text = item.name
            binding.insertnum.text = item.count
        }
    }//45
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=PersonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount()= datas.size
/*

*/
}