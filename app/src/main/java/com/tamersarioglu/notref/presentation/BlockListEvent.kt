package com.tamersarioglu.notref.presentation

import com.tamersarioglu.notref.domain.model.BlockedPerson

sealed class BlockListEvent {
    data class AddPerson(
        val name: String,
        val socialMediaUsername: String? = null,
        val age: String? = null,
        val reason: String? = null
    ) : BlockListEvent()
    data class RemovePerson(val person: BlockedPerson) : BlockListEvent()
    data object ShowDialog : BlockListEvent()
    data object DismissDialog : BlockListEvent()
}