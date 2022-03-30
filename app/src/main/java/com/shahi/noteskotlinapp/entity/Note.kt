package com.shahi.noteskotlinapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "subTitle")
    var subTitle: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "dateTime")
    var dateTime: String
)