package com.tamersarioglu.notref.domain.use_case

import com.tamersarioglu.notref.domain.model.BlockedPerson
import com.tamersarioglu.notref.domain.repository.BlockListRepository
import javax.inject.Inject

class BlockListUseCases @Inject constructor(
    private val repository: BlockListRepository
) {
    fun getBlockedPersons() = repository.getBlockedPersons()
    
    suspend fun addBlockedPerson(
        name: String,
        socialMediaUsername: String? = null,
        age: String? = null,
        reason: String? = null
    ) {
        if (name.isBlank()) throw IllegalArgumentException("İsim boş olamaz")
        
        repository.addBlockedPerson(
            BlockedPerson(
                name = name.trim(),
                socialMediaUsername = socialMediaUsername?.trim(),
                age = age,
                reason = reason?.trim()
            )
        )
    }
    
    suspend fun removeBlockedPerson(person: BlockedPerson) {
        repository.removeBlockedPerson(person)
    }
} 