package com.tamersarioglu.notref.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamersarioglu.notref.domain.use_case.BlockListUseCases
import com.tamersarioglu.notref.presentation.BlockListEvent
import com.tamersarioglu.notref.presentation.BlockListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlockListViewModel @Inject constructor(
    private val blockListUseCases: BlockListUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(BlockListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            blockListUseCases.getBlockedPersons().collect { persons ->
                _state.update { it.copy(
                    blockedPersons = persons
                )}
            }
        }
    }

    fun onEvent(event: BlockListEvent) {
        when(event) {
            is BlockListEvent.AddPerson -> {
                viewModelScope.launch {
                    try {
                        blockListUseCases.addBlockedPerson(
                            name = event.name,
                            socialMediaUsername = event.socialMediaUsername,
                            age = event.age,
                            reason = event.reason
                        )
                        _state.update { it.copy(
                            isAddingPerson = false,
                            error = null
                        )}
                    } catch(e: Exception) {
                        _state.update { it.copy(
                            error = e.message
                        )}
                    }
                }
            }
            BlockListEvent.DismissDialog -> {
                _state.update { it.copy(
                    isAddingPerson = false,
                    error = null
                )}
            }
            BlockListEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingPerson = true
                )}
            }
            is BlockListEvent.RemovePerson -> {
                viewModelScope.launch {
                    blockListUseCases.removeBlockedPerson(event.person)
                }
            }
        }
    }
}