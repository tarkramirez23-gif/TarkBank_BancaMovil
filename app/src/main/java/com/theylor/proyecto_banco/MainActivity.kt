package com.theylor.proyecto_banco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.theylor.proyecto_banco.navigation.AppNavigation
import com.theylor.proyecto_banco.ui.theme.Proyecto_BancoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Proyecto_BancoTheme {
                AppNavigation()
            }
        }
    }
}
