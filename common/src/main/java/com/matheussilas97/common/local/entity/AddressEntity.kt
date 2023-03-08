package com.matheussilas97.common.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AddressEntity(

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
