package com.theylor.proyecto_banco.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val BankColorScheme = lightColorScheme(
    primary = White,
    onPrimary = NavyBlue,
    primaryContainer = NavyBlueLight,
    onPrimaryContainer = White,
    secondary = GoldAccent,
    onSecondary = NavyBlue,
    background = NavyBlue,
    surface = NavyBlueSoft,
    onBackground = White,
    onSurface = White,
)

@Composable
fun Proyecto_BancoTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = BankColorScheme,
        typography = Typography,
        content = content
    )
}
