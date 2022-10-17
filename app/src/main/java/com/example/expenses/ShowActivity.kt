package com.example.expenses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.example.expenses.data.ContactDataBase
import com.example.expenses.data.DATABASE_NAME
import com.example.expenses.data.ContactRVAdapter
import com.example.expenses.data.models.Contacts
import com.example.expenses.data.models.JobsTypes
import com.example.expenses.databinding.ActivityShowBinding

class ShowActivity : AppCompatActivity() {

    private var contList: MutableList<Contacts> = mutableListOf()
    private var typesList: MutableList<JobsTypes> = mutableListOf()
    private var db: ContactDataBase? = null
    private lateinit var b: ActivityShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityShowBinding.inflate(layoutInflater)
        setContentView(b.root)
        db = Room.databaseBuilder(this, ContactDataBase::class.java, DATABASE_NAME).build()
    }

    private fun getContact() {
        contList.clear()
        typesList.clear()
        db?.contactDAO()?.getAllJob()?.observe(this, androidx.lifecycle.Observer {
            typesList.addAll(it)
        })
        db?.contactDAO()?.getAllContact()?.observe(this, androidx.lifecycle.Observer {
            contList.addAll(it)
            getRecycleView()
        })

    }

    override fun onResume() {
        super.onResume()
        getContact()

    }

    private fun getRecycleView(){
        val rvListener = object : ContactRVAdapter.ItemClickListener {
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(this@ShowActivity, MainActivity::class.java)
                intent.putExtra("pos", position)
                intent.putExtra("uuid", contList[position].uuid.toString())
                intent.putExtra("uuidType", typesList[position].uuid.toString())
                startActivity(intent)

            }
        }
        val adapter = ContactRVAdapter(this, contList, typesList)
        adapter.setClickListener(rvListener)
        b.recycler.adapter = adapter

    }
}