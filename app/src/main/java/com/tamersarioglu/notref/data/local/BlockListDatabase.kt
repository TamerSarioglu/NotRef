package com.tamersarioglu.notref.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [BlockedPersonEntity::class],
    version = 4
)
abstract class BlockListDatabase : RoomDatabase() {
    abstract val dao: BlockedPersonDao
} 