package com.matheussilas97.data_module.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.matheussilas97.data_module.local.entity.Address

@Dao
interface AddressDao {

    @Query("SELECT * FROM address")
    fun getAll(): List<Address>

    @Insert
    fun insert(address: Address): Long

    @Delete
    fun deleteTraining(address: Address)

}