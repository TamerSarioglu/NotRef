package com.tamersarioglu.notref.domain.model

data class BlockedPerson(
    val id: Int = 0,
    val name: String,
    val socialMediaUsername: String? = null,
    val age: String? = null,
    val reason: String? = null,
    val timestamp: Long = System.currentTimeMillis()
) 