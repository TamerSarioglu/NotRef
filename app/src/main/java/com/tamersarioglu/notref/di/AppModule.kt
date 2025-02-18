package com.tamersarioglu.notref.di

import android.app.Application
import androidx.room.Room
import com.tamersarioglu.notref.data.local.BlockListDatabase
import com.tamersarioglu.notref.data.repository.BlockListRepositoryImpl
import com.tamersarioglu.notref.domain.repository.BlockListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideBlockListDatabase(app: Application): BlockListDatabase {
        return Room.databaseBuilder(
            app,
            BlockListDatabase::class.java,
            "blocklist.db"
        )
        .fallbackToDestructiveMigration()
        .build()
    }
    
    @Provides
    @Singleton
    fun provideBlockListRepository(db: BlockListDatabase): BlockListRepository {
        return BlockListRepositoryImpl(db)
    }
} 