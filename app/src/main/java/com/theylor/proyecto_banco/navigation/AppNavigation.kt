package com.theylor.proyecto_banco.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theylor.proyecto_banco.ui.screens.*

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Register : Screen("register")
    object Dashboard : Screen("home")
    object Transactions : Screen("transactions")
    object Transfer : Screen("transfer")
    object Cards : Screen("cards")
    object PayServices : Screen("pay_services")
    object Yape : Screen("yape")
    object Shopping : Screen("shopping")
    object Settings : Screen("settings")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }

        composable(Screen.Login.route) {
            LoginScreen(onLoginSuccess = {
                navController.navigate(Screen.Dashboard.route) {
                    popUpTo(Screen.Welcome.route) { inclusive = true }
                }
            })
        }

        composable(Screen.Register.route) {
            RegisterScreen(
                onNavigateBack = { navController.popBackStack() },
                onRegisterSuccess = {
                    navController.navigate(Screen.Welcome.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Dashboard.route) {
            HomeScreen(
                onNavigateToTransfer = {
                    navController.navigate(Screen.Transfer.route)
                },
                onNavigateToTransactions = {
                    navController.navigate(Screen.Transactions.route)
                },
                onNavigateToCards = {
                    navController.navigate(Screen.Cards.route)
                },
                onNavigateToPayServices = {
                    navController.navigate(Screen.PayServices.route)
                },
                onNavigateToYape = {
                    navController.navigate(Screen.Yape.route)
                },
                onNavigateToShopping = {
                    navController.navigate(Screen.Shopping.route)
                },
                onNavigateToSettings = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }

        composable(Screen.Transactions.route) {
            TransactionsScreen(onNavigateBack = {
                navController.popBackStack()
            })
        }

        composable(Screen.Cards.route) {
            CardsScreen(onNavigateBack = {
                navController.popBackStack()
            })
        }

        composable(Screen.Transfer.route) {
            TransferScreen(onNavigateBack = {
                navController.popBackStack()
            })
        }

        composable(Screen.PayServices.route) {
            PayServicesScreen(onNavigateBack = {
                navController.popBackStack()
            })
        }

        composable(Screen.Yape.route) {
            YapeScreen(onNavigateBack = {
                navController.popBackStack()
            })
        }

        composable(Screen.Shopping.route) {
            ComprasScreen(onNavigateBack = {
                navController.popBackStack()
            })
        }

        composable(Screen.Settings.route) {
            AjustesScreen(
                onNavigateBack = { navController.popBackStack() },
                onLogout = {
                    navController.navigate(Screen.Welcome.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}
