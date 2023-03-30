package com.mtali.tigopesa.app.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mtali.tigopesa.app.ui.TigoPesaApp
import com.mtali.tigopesa.core.ui.theme.TigoPesaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TigoPesaTheme {
                // A surface container using the 'background' color from the theme
                TigoPesaApp()
            }
        }
    }
}
