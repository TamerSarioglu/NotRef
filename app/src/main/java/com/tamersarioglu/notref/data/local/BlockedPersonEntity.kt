package com.tamersarioglu.notref.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blocked_persons")
data class BlockedPersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val socialMediaUsername: String? = null,
    val age: String? = null,
    val reason: String? = null,
    val timestamp: Long = System.currentTimeMillis()
) 