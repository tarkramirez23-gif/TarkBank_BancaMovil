package com.theylor.proyecto_banco.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YapeScreen(onNavigateBack: () -> Unit) {
    var step by remember { mutableIntStateOf(0) } // 0: Contacto, 1: Monto, 2: Éxito
    var phoneNumber by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var isMessageVisible by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    when (step) {
        0 -> {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    TopAppBar(
                        title = { Text("Yapear a celular", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold) },
                        navigationIcon = {
                            IconButton(onClick = onNavigateBack) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = MaterialTheme.colorScheme.primary)
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
                    )
                }
            ) { padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .padding(24.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Detalles del destinatario",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange = { if (it.length <= 9) phoneNumber = it },
                        label = { Text("Busca contacto o ingresa el celular") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = { 
                            keyboardController?.hide()
                            step = 1 
                        },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        enabled = phoneNumber.length == 9,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("Siguiente", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }
                }
            }
        }
        1 -> {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    TopAppBar(
                        title = { Text("Yapear a $phoneNumber", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold) },
                        navigationIcon = {
                            IconButton(onClick = { step = 0 }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Atrás", tint = MaterialTheme.colorScheme.primary)
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
                    )
                }
            ) { padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .padding(horizontal = 24.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Sección "Desde"
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Desde",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        var selectedAccount by remember { mutableIntStateOf(0) } // 0: Ahorro, 1: Crédito

                        // Botón Cuenta de Ahorro
                        Card(
                            onClick = { selectedAccount = 0 },
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = if (selectedAccount == 0) 
                                    MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) 
                                    else MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
                            ),
                            border = if (selectedAccount == 0) 
                                androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary) 
                                else null,
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    Icons.Default.AccountBalanceWallet,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "Cuenta de ahorro",
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontSize = 14.sp
                                    )
                                    Text(
                                        text = "**** 1234",
                                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                                        fontSize = 12.sp
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "S/. 2,540.50",
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 14.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Botón Tarjeta de Crédito
                        Card(
                            onClick = { selectedAccount = 1 },
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = if (selectedAccount == 1) 
                                    MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) 
                                    else MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
                            ),
                            border = if (selectedAccount == 1) 
                                androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary) 
                                else null,
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    Icons.Default.CreditCard,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "Tarjeta de crédito",
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontSize = 14.sp
                                    )
                                    Text(
                                        text = "**** 5678",
                                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                                        fontSize = 12.sp
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "S/. 5,000.000",
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Monto a yapear",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "S/. ${if (amount.isEmpty()) "0.00" else amount}",
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AmountKeypad(
                        onDigitClick = { digit -> if (amount.length < 7) amount += digit },
                        onDeleteClick = { if (amount.isNotEmpty()) amount = amount.dropLast(1) },
                        onDotClick = { if (!amount.contains(".") && amount.isNotEmpty()) amount += "." }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AnimatedVisibility(visible = !isMessageVisible) {
                        TextButton(onClick = { isMessageVisible = true }) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Mensaje (Opcional)", fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    AnimatedVisibility(
                        visible = isMessageVisible,
                        enter = expandVertically() + fadeIn(),
                        exit = shrinkVertically() + fadeOut()
                    ) {
                        OutlinedTextField(
                            value = message,
                            onValueChange = { message = it },
                            label = { Text("Escribe un mensaje") },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                            maxLines = 2,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = MaterialTheme.colorScheme.primary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { step = 2 },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        enabled = amount.isNotEmpty() && (amount.toDoubleOrNull() ?: 0.0) > 0.0,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("Yapear", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }
                }
            }
        }
        2 -> {
            SuccessYapeView(
                amount = amount,
                phoneNumber = phoneNumber,
                message = message,
                onClose = onNavigateBack
            )
        }
    }
}

@Composable
fun AmountKeypad(
    onDigitClick: (String) -> Unit,
    onDeleteClick: () -> Unit,
    onDotClick: () -> Unit
) {
    val keys = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf(".", "0", "DEL")
    )

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        keys.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { key ->
                    Surface(
                        onClick = {
                            when (key) {
                                "DEL" -> onDeleteClick()
                                "." -> onDotClick()
                                else -> onDigitClick(key)
                            }
                        },
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.2f),
                        modifier = Modifier.size(width = 80.dp, height = 50.dp).weight(1f)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            if (key == "DEL") {
                                Icon(Icons.Default.Backspace, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            } else {
                                Text(key, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SuccessYapeView(
    amount: String,
    phoneNumber: String,
    message: String = "",
    onClose: () -> Unit
) {
    val formattedAmount = amount.toDoubleOrNull()?.let { "%.2f".format(it) } ?: amount

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = Color(0xFF4CAF50),
                modifier = Modifier.size(120.dp)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "¡Yapeo exitoso!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "S/. $formattedAmount",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            
            Text(
                text = "Enviado a $phoneNumber",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = 8.dp)
            )

            if (message.isNotEmpty()) {
                Text(
                    text = "\"$message\"",
                    fontSize = 16.sp,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(48.dp))
            
            Button(
                onClick = onClose,
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Listo", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }
    }
}
