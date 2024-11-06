package com.dck.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.dck.module_a.presentation.HomeScreen
import com.dck.module_a.presentation.ScreenA
import com.dck.module_b.presentation.ScreenB
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.generated.modulea.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.generated.modulea.destinations.ScreenADestination
import com.ramcosta.composedestinations.generated.moduleb.destinations.ScreenBDestination
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.rememberNavHostEngine

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    val navHostEngine = rememberNavHostEngine()

    DestinationsNavHost(navController = navController, engine = navHostEngine, navGraph = NavGraphs.main) {

        composable(HomeScreenDestination) {
            HomeScreen {
                destinationsNavigator.navigate(ScreenADestination)
            }
        }
        composable(ScreenADestination) {
            ScreenA (navigateBack = destinationsNavigator::popBackStack){
                destinationsNavigator.navigate(ScreenBDestination(it))
            }
        }
        composable(ScreenBDestination) {
            val message = ScreenBDestination.argsFrom(navBackStackEntry.arguments).message
            ScreenB(message = message, navigateBack = destinationsNavigator::popBackStack) {
                destinationsNavigator.navigate(HomeScreenDestination)
            }
        }
    }
}