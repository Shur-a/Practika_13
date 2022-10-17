package com.example.expenses.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.expenses.data.JOB_TABLE
import java.util.*

@Entity(tableName = JOB_TABLE)
data class JobsTypes (
    @PrimaryKey(autoGenerate = false)
    var uuid: UUID,
    var typesJob: String
)