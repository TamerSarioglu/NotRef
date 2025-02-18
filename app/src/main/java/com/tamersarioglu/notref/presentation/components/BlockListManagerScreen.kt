package com.tamersarioglu.notref.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BlacklistManagerScreen(
    onDismiss: () -> Unit,
    onAdd: (name: String, socialMediaUsername: String?, age: String?, reason: String?) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var socialMediaUsername by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFFF0F4FF)  //Soft background color
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Create,
                    contentDescription = "Shield Icon",
                    tint = Color(0xFF6495ED), // Soft blue
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Kara Liste Yöneticisi",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6495ED) // Soft blue
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Yeni Ekle",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    CustomTextField(
                        placeholder = "İsim girin",
                        value = name,
                        onValueChange = { name = it })

                    CustomTextField(
                        placeholder = "@kullaniciadi",
                        value = socialMediaUsername,
                        onValueChange = { socialMediaUsername = it })

                    CustomTextField(
                        placeholder = "Yaş girin",
                        value = age,
                        onValueChange = { age = it })

                    CustomTextField(
                        placeholder = "Kara listeye eklenme sebebini yazın",
                        value = description,
                        onValueChange = { description = it })

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            onAdd(
                                name,
                                socialMediaUsername.takeIf { it.isNotBlank() },
                                age.takeIf { it.isNotBlank() },
                                description.takeIf { it.isNotBlank() }
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors()
                    ) {
                        Text(text = "Kara Listeye Ekle")
                    }

                    Button(
                        onClick = onDismiss,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors()
                    ) {
                        Text(text = "İptal")
                    }
                }
            }
        }
    }
}

@Composable
fun CustomTextField(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BlacklistManagerScreen(
        onDismiss = {},
        onAdd = { _, _, _, _ -> }
    )
}
