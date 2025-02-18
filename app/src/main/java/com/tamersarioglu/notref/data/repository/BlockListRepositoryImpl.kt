package com.tamersarioglu.notref.data.repository

import com.tamersarioglu.notref.data.local.BlockListDatabase
import com.tamersarioglu.notref.data.local.BlockedPersonEntity
import com.tamersarioglu.notref.domain.model.BlockedPerson
import com.tamersarioglu.notref.domain.repository.BlockListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BlockListRepositoryImpl @Inject constructor(
    private val database: BlockListDatabase
) : BlockListRepository {
    
    override fun getBlockedPersons(): Flow<List<BlockedPerson>> {
        return database.dao.getAllBlockedPersons().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }
    
    override suspend fun addBlockedPerson(person: BlockedPerson) {
        database.dao.insertBlockedPerson(person.toEntity())
    }
    
    override suspend fun removeBlockedPerson(person: BlockedPerson) {
        database.dao.deleteBlockedPerson(person.toEntity())
    }
    
    private fun BlockedPersonEntity.toDomainModel() = BlockedPerson(
        id = id,
        name = name,
        reason = reason,
        timestamp = timestamp,
        age = age,
        socialMediaUsername = socialMediaUsername
    )
    
    private fun BlockedPerson.toEntity() = BlockedPersonEntity(
        id = id,
        name = name,
        reason = reason,
        timestamp = timestamp,
        age = age,
        socialMediaUsername = socialMediaUsername
    )
} 