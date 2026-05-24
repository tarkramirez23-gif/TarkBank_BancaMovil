package com.theylor.proyecto_banco.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComprasScreen(onNavigateBack: () -> Unit) {
    val shopCategories = listOf(
        ShopCategory("Supermercados", Icons.Default.ShoppingCart, "Descuentos en Plaza Vea y Vivanda"),
        ShopCategory("Restaurantes", Icons.Default.Restaurant, "Hasta 30% de dscto en socios"),
        ShopCategory("Moda", Icons.Default.Checkroom, "Nuevas colecciones con tu tarjeta"),
        ShopCategory("Tecnología", Icons.Default.Devices, "Cuotas sin intereses en tiendas top"),
        ShopCategory("Hogar", Icons.Default.Home, "Todo para remodelar tu espacio"),
        ShopCategory("Viajes", Icons.Default.Flight, "Acumula millas con cada compra")
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = "Compras y descuentos",
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
        ) {
            // Banner de promoción
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(text = "¡Semana de Locura!", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = "Usa tus tarjetas TarkBank y obtén beneficios exclusivos en miles de tiendas.")
                }
            }

            Text(
                text = "Categorías destacadas",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(shopCategories) { category ->
                    ShopCategoryItem(category)
                }
            }
        }
    }
}

data class ShopCategory(val name: String, val icon: ImageVector, val description: String)

@Composable
fun ShopCategoryItem(category: ShopCategory) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f),
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.Transparent),
            headlineContent = { Text(text = category.name, fontWeight = FontWeight.Bold) },
            supportingContent = { Text(text = category.description, fontSize = 12.sp) },
            leadingContent = {
                Icon(
                    imageVector = category.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
    }
}
