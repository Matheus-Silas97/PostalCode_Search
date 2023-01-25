package com.matheussilas97.data_module.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Address(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "postal_code")
    val postalCode: String,

    val street: String,

    val complement: String,

    val neighborhood: String,

    val city: String,

    val state: String
)
