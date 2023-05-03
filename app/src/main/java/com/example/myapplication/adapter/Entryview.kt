package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class Entryview(private val context: Context) : RecyclerView.Adapter<Entryview.ViewHolder>() {

    var datas = mutableListOf<ProfileData>()
    class ProfileData (
        val name : String,
        val count : Int,
        val num : MutableList<Int> = MutableList(count, {i->i}),
        )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.result_person, parent, false)
        )
    }
    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtName: TextView = itemView.findViewById(R.id.ID_show)
        private val txtCount: TextView = itemView.findViewById(R.id.resultnum)
        fun bind(item: ProfileData) {
            txtName.text = item.name
            txtCount.text = item.num.toString()
        }
    }


}