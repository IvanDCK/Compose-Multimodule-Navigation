package com.dck.core.navigation

import com.ramcosta.composedestinations.annotation.ExternalNavGraph
import com.ramcosta.composedestinations.annotation.NavHostGraph
import com.ramcosta.composedestinations.generated.modulea.navgraphs.ModuleANavGraph
import com.ramcosta.composedestinations.generated.moduleb.navgraphs.ModuleBNavGraph

@NavHostGraph
annotation class MainGraph {

    @ExternalNavGraph<ModuleANavGraph>(start = true)
    @ExternalNavGraph<ModuleBNavGraph>
    companion object Includes
}