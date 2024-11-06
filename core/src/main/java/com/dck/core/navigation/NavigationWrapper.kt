package com.dck.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.dck.module_a.presentation.HomeScreen
import com.dck.module_a.presentation.NavGraphs
import com.dck.module_a.presentation.ScreenA
import com.dck.module_a.presentation.destinations.HomeScreenDestination
import com.dck.module_a.presentation.destinations.ScreenADestination
import com.dck.module_b.presentation.destinations.ScreenBDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    val navHostEngine = rememberNavHostEngine()


    DestinationsNavHost(navController = navController, engine = navHostEngine, navGraph = NavGraphs.root) {
        composable(HomeScreenDestination) {
            HomeScreen {
                destinationsNavigator.navigate(ScreenADestination)
            }
        }
        composable(ScreenADestination) {
            ScreenA {
                // destinationsNavigator.navigate(ScreenBDestination)
            }
        }
    }
}