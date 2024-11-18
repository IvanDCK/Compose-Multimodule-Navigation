package com.dck.core.navigation

import com.dck.module_b.model.Mobile
import kotlinx.serialization.Serializable


@Serializable
object HomeScreen

@Serializable
object ScreenA

@Serializable
object ScreenB

@Serializable
data class ScreenC(val mobile: Mobile)