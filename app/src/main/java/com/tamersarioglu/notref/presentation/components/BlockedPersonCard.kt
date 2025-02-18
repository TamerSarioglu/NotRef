package com.tamersarioglu.notref.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tamersarioglu.notref.domain.model.BlockedPerson
import com.tamersarioglu.notref.utils.Utils.formatTimestamp

@Composable
fun BlockedPersonCard(
    person: BlockedPerson,
    onDelete: (BlockedPerson) -> Unit
) {
    var showOptions by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Name: ${person.name}",
                        style = MaterialTheme.typography.titleMedium
                    )

                    person.socialMediaUsername?.let { username ->
                        Text(
                            text = "Username: @$username",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    person.age?.let { age ->
                        Text(
                            text = "Age: $age",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    person.reason?.let { reason ->
                        if (reason.isNotBlank()) {
                            Text(
                                text = "Reason: $reason",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }

                    Text(
                        text = formatTimestamp(person.timestamp),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                }

                IconButton(onClick = { showOptions = true }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More options"
                    )
                }
            }
        }
    }

    if (showOptions) {
        AlertDialog(
            onDismissRequest = { showOptions = false },
            title = { Text("Seçenekler") },
            text = { Text("Bu kişiyi kara listeden kaldırmak istiyor musunuz?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDelete(person)
                        showOptions = false
                    }
                ) {
                    Text("Kaldır")
                }
            },
            dismissButton = {
                TextButton(onClick = { showOptions = false }) {
                    Text("İptal")
                }
            }
        )
    }
}
