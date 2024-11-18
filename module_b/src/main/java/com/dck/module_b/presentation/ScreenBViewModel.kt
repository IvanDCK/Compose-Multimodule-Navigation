package com.dck.module_b.presentation

import androidx.lifecycle.ViewModel
import com.dck.module_b.model.Mobile

class ScreenBViewModel(
    private val mobile: Mobile
): ViewModel() {
    fun injectMobile(): Mobile {
        return mobile
    }
}