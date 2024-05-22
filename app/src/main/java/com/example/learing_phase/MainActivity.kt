package com.example.learing_phase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learing_phase.ui.theme.Learing_phaseTheme
import com.example.learing_phase.ui.theme.UnitConverterUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Learing_phaseTheme {
                // A surface container using the 'background' color from the theme
                UnitConverterUI();

            }
        }
    }
}



