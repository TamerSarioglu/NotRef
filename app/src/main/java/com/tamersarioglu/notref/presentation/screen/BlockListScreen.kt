package com.tamersarioglu.notref.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tamersarioglu.notref.presentation.BlockListEvent
import com.tamersarioglu.notref.presentation.components.BlacklistManagerScreen
import com.tamersarioglu.notref.presentation.components.BlockedPersonCard
import com.tamersarioglu.notref.presentation.components.EmptyStateContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlockListScreen() {
    val viewModel: BlockListViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onEvent(BlockListEvent.ShowDialog) }
            ) {
                Text("+")
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when {
                state.blockedPersons.isEmpty() -> {
                    EmptyStateContent(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(state.blockedPersons) { person ->
                            BlockedPersonCard(
                                person = person,
                                onDelete = {
                                    viewModel.onEvent(BlockListEvent.RemovePerson(it))
                                }
                            )
                        }
                    }
                }
            }

            if (state.isAddingPerson) {
                ModalBottomSheet(
                    onDismissRequest = {
                        viewModel.onEvent(BlockListEvent.DismissDialog)
                    },
                    sheetState = sheetState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    BlacklistManagerScreen(
                        onDismiss = { viewModel.onEvent(BlockListEvent.DismissDialog) },
                        onAdd = { name, socialMediaUsername, age, reason ->
                            viewModel.onEvent(
                                BlockListEvent.AddPerson(
                                    name = name,
                                    socialMediaUsername = socialMediaUsername,
                                    age = age,
                                    reason = reason
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}