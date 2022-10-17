package com.example.expenses.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.expenses.data.models.Contacts
import com.example.expenses.data.models.JobsTypes

@Database(entities = [JobsTypes::class, Contacts::class], version = 1)
abstract class ContactDataBase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO
}