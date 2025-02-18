package com.tamersarioglu.notref.presentation

import com.tamersarioglu.notref.domain.model.BlockedPerson

data class BlockListState(
    val blockedPersons: List<BlockedPerson> = emptyList(),
    val isAddingPerson: Boolean = false,
    val error: String? = null
)