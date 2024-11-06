package com.dck.core.navigation

import kotlinx.serialization.Serializable


@Serializable
object HomeScreen

@Serializable
object ScreenA

@Serializable
object ScreenB

@Serializable
data class ScreenC(val message: String)