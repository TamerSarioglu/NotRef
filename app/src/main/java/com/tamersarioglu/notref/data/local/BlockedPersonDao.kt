package com.tamersarioglu.notref.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BlockedPersonDao {
    @Query("SELECT * FROM blocked_persons ORDER BY timestamp DESC")
    fun getAllBlockedPersons(): Flow<List<BlockedPersonEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlockedPerson(person: BlockedPersonEntity)
    
    @Delete
    suspend fun deleteBlockedPerson(person: BlockedPersonEntity)
} 