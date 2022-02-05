package com.contactdevloperdk.gitubapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response
import java.util.ArrayList

class Repadapter(val context:Context, var userlist: List<Repmodel>): RecyclerView.Adapter<Repadapter.viewholder>() {
    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView:TextView=itemView.findViewById(R.id.textView3)
        val textView2:TextView=itemView.findViewById(R.id.textView9)
        val textView3:TextView=itemView.findViewById(R.id.textView13)
        val textView4:TextView=itemView.findViewById(R.id.textView15)
        val textView5:TextView=itemView.findViewById(R.id.guc)
        val textView6:TextView=itemView.findViewById(R.id.starc)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder{
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.rep_item,parent,false)
        return viewholder(itemView)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val currentItem = userlist[position]
       holder.textView.text=currentItem.name
        holder.textView2.text=currentItem.language
        holder.textView3.text=currentItem.watchers.toString()
        holder.textView4.text=currentItem.oppen_issues.toString()
        holder.textView5.text=currentItem.forks.toString()
        holder.textView6.text=currentItem.stargazers_count.toString()
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
    fun  setdata(userlist: List<Repmodel>){
        this.userlist = userlist
        notifyDataSetChanged()
    }
}