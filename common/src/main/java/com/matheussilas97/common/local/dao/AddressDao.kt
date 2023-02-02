package com.matheussilas97.common.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.matheussilas97.common.local.entity.Address

@Dao
interface AddressDao {

    @Query("SELECT * FROM address")
    fun getAll(): List<Address>

    @Insert
    fun insert(address: Address)

    @Delete
    fun deleteTraining(address: Address)

}