package com.dck.module_b.presentation

import androidx.lifecycle.ViewModel
import com.dck.module_b.presentation.model.Mobile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenCViewModel @Inject constructor(
    private val mobile: Mobile
): ViewModel() {

    fun getMobile(): Mobile {
        return mobile
    }
}