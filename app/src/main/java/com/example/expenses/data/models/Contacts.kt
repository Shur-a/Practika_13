package com.example.expenses.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.expenses.data.CONTACTS_TABLE
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = CONTACTS_TABLE)
data class Contacts (
    @PrimaryKey(autoGenerate = false)
    @NotNull
    var uuid: UUID,
    var nameContact: String,
    var numberContact: Int,

    @ColumnInfo(index = true)
    var typeJob: UUID
    )