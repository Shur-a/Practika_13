package com.example.expenses.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expenses.data.models.Contacts
import com.example.expenses.data.models.JobsTypes
import java.util.*

@Dao
interface ContactDAO {
    @Query("SELECT * FROM $JOB_TABLE")
    fun getAllJob(): LiveData<MutableList<JobsTypes>>
    @Query("SELECT typesJob FROM $JOB_TABLE WHERE uuid =:id")
    fun getTypeJobName(id: UUID): String
    @Update
    fun updateTypeJob (type: JobsTypes)
    @Insert
    fun addTypeJob (type: JobsTypes)
    @Delete
    fun deleteType (type: JobsTypes)

    @Query("SELECT * FROM $CONTACTS_TABLE")
    fun getAllContact(): LiveData<MutableList<Contacts>>
    @Query("SELECT * FROM $CONTACTS_TABLE WHERE uuid=:id")
    fun getContact(id: UUID): Contacts
    @Insert
    fun addContact(contacts: Contacts)
    @Update
    fun updateContact(contacts: Contacts)
    @Delete
    fun deleteContact(contacts: Contacts)
}