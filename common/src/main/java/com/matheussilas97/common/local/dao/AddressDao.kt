package com.matheussilas97.common.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.matheussilas97.common.local.entity.AddressEntity

@Dao
interface AddressDao {

    @Query("SELECT * FROM addressentity")
    fun getAll(): List<AddressEntity>

    @Insert
    fun insert(address: AddressEntity)

    @Delete
    fun deleteTraining(address: AddressEntity)

}