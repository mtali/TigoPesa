package com.mtali.tigopesa.app.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.mtali.tigopesa.core.ui.theme.BrightestGray
import com.mtali.tigopesa.core.ui.theme.TigoPesaTheme
import com.mtali.tigopesa.feature.home.HomeRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TigoPesaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BrightestGray
                ) {
                    HomeRoute()
                }
            }
        }
    }
}
