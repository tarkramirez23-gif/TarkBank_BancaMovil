package com.theylor.proyecto_banco.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.theylor.proyecto_banco.model.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(onNavigateBack: () -> Unit) {
    val transactions = listOf(
        Transaction(1, "Pago de Nómina", 1200.0, "15 Oct", TransactionType.INCOME),
        Transaction(2, "Supermercado", -85.20, "16 Oct", TransactionType.EXPENSE),
        Transaction(3, "Suscripción Netflix", -12.99, "17 Oct", TransactionType.EXPENSE),
        Transaction(4, "Transferencia Recibida", 500.0, "18 Oct", TransactionType.INCOME),
        Transaction(5, "Restaurante", -45.00, "19 Oct", TransactionType.EXPENSE),
        Transaction(6, "Gasolinera", -60.00, "20 Oct", TransactionType.EXPENSE)
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Movimientos", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.Default.ArrowBack, 
                            contentDescription = "Volver",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(transactions) { transaction ->
                TransactionItem(transaction)
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    ListItem(
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
            headlineColor = MaterialTheme.colorScheme.onSurface,
            supportingColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        ),
        headlineContent = { Text(transaction.title, fontWeight = FontWeight.Bold) },
        supportingContent = { Text(transaction.date) },
        trailingContent = {
            Text(
                text = "${if (transaction.type == TransactionType.INCOME) "+" else "-"} S/. ${"%.2f".format(Math.abs(transaction.amount))}",
                color = if (transaction.type == TransactionType.INCOME) Color(0xFF4CAF50) else Color(0xFFFF5252),
                fontWeight = FontWeight.Bold
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}
