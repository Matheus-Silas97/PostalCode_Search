package com.matheussilas97.data_module.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matheussilas97.data_module.local.dao.AddressDao
import com.matheussilas97.data_module.local.entity.Address

@Database(entities = [Address::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun address(): AddressDao
}