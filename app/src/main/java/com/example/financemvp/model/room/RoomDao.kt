package com.example.financemvp.model.room

import androidx.room.*
import com.example.financemvp.model.models.Transaction

@Dao
interface RoomDao {
    @Query("SELECT * FROM transactions")
    fun getAll(): List<Transaction>

    @Insert
     fun insert(vararg transaction: Transaction)

    @Update
     fun update(transaction: Transaction)

    @Delete
     fun delete(transaction: Transaction)

}