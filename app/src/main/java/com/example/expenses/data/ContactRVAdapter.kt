package com.example.expenses.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expenses.R
import com.example.expenses.data.models.Contacts
import com.example.expenses.data.models.JobsTypes

class ContactRVAdapter(context: Context?,
                       private val data:MutableList<Contacts>,
                       private val dataTypes:MutableList<JobsTypes>)
    : RecyclerView.Adapter<ContactRVAdapter.ContactViewHolder>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view: View = layoutInflater.inflate(R.layout.item_expense, parent, false)
        return ContactViewHolder(view)
    }

    private var iClickListener: ItemClickListener? = null

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = data[position]
        val itemType = dataTypes[position]
        holder.name.text = item.nameContact
        holder.number.text = item.numberContact.toString()
        holder.job.text = itemType.typesJob
    }

    override fun getItemCount(): Int = data.size

    inner class ContactViewHolder(item: View) : RecyclerView.ViewHolder(item), View.OnClickListener{
        var name: TextView = item.findViewById(R.id.tvName)
        var number: TextView = item.findViewById(R.id.tvnumber)
        var job: TextView = item.findViewById(R.id.tvjob)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(view: View?){
            iClickListener?.onItemClick(view, adapterPosition)
        }
    }

    fun setClickListener(itemClickListener: ItemClickListener?){
        iClickListener = itemClickListener
    }
    interface ItemClickListener{
        fun onItemClick(view: View?, position: Int)
    }
}