package com.tamersarioglu.notref.domain.repository

import com.tamersarioglu.notref.domain.model.BlockedPerson
import kotlinx.coroutines.flow.Flow

interface BlockListRepository {
    fun getBlockedPersons(): Flow<List<BlockedPerson>>
    suspend fun addBlockedPerson(person: BlockedPerson)
    suspend fun removeBlockedPerson(person: BlockedPerson)
} 