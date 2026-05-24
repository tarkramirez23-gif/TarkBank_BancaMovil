package com.theylor.proyecto_banco.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.theylor.proyecto_banco.model.Account
import com.theylor.proyecto_banco.ui.components.BankCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardsScreen(onNavigateBack: () -> Unit) {
    val debitAccount = Account("Visa", 2540.50, "**** 1234")
    val creditAccount = Account("Visa", 5000000.00, "**** 5678")

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = "Mis tarjetas",
                        color = MaterialTheme.colorScheme.primary, 
                        fontWeight = FontWeight.Bold
                    ) 
                },
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
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Débito",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            BankCard(
                account = debitAccount,
                cardType = "Tarjeta de Débito",
                gradientColors = listOf(Color(0xFF003366), Color(0xFF00509E))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Crédito",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
            BankCard(
                account = creditAccount,
                cardType = "Tarjeta de Crédito Black",
                gradientColors = listOf(Color(0xFF424242), Color(0xFF212121)) // Tonos plomo oscuro/negro
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Sección de información adicional
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Seguridad",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Tus tarjetas están protegidas. Puedes bloquearlas temporalmente desde la configuración.",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
