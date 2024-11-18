package com.dck.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dck.core.navigation.type.createNavType
import com.dck.module_a.presentation.HomeScreen
import com.dck.module_a.presentation.ScreenA
import com.dck.module_b.model.Mobile
import com.dck.module_b.presentation.ScreenB
import com.dck.module_b.presentation.ScreenC
import kotlin.reflect.typeOf

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
                navigateToC = { mobile -> navController.navigate(ScreenC(mobile = mobile)) },
                navigateBack = { navController.popBackStack() }
            )
        }
       composable<ScreenC>(typeMap = mapOf(typeOf<Mobile>() to createNavType<Mobile>())) { backStackEntry ->
           val screenC = backStackEntry.toRoute<ScreenC>()
           ScreenC(
               mobile = screenC.mobile,
               navigateToHome = { navController.navigate(HomeScreen) {
                   popUpTo<HomeScreen>{ inclusive = true }
               } },
               navigateBack = { navController.popBackStack() }
               )
       }
    }
}