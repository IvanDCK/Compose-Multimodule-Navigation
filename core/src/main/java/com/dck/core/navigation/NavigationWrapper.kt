package com.dck.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dck.module_a.presentation.HomeScreen
import com.dck.module_a.presentation.ScreenA
import com.dck.module_b.presentation.ScreenB
import com.dck.module_b.presentation.ScreenC

@Composable
fun NavigationWrapper() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen> {
           HomeScreen {
                navController.navigate(ScreenA) }
        }
        composable<ScreenA> {
            ScreenA (
               navigateToB = { navController.navigate(ScreenB) },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable<ScreenB> {
            ScreenB(
                navigateToC = { message -> navController.navigate(ScreenC(message = message)) },
                navigateBack = { navController.popBackStack() }
            )
        }
       composable<ScreenC> { backStackEntry ->
           val message = backStackEntry.toRoute<ScreenC>().message
           ScreenC(message = message,
               navigateToHome = { navController.navigate(HomeScreen) {
                   popUpTo<HomeScreen>{ inclusive = true }
               } },
               navigateBack = { navController.popBackStack() }
               )
       }
    }
}