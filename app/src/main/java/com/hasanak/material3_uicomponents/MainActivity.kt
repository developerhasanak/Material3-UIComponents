package com.hasanak.material3_uicomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hasanak.material3_uicomponents.checkboxes_switches_radiobuttons.MyCheckboxes
import com.hasanak.material3_uicomponents.checkboxes_switches_radiobuttons.MyRadioButtons
import com.hasanak.material3_uicomponents.checkboxes_switches_radiobuttons.MySwitch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                MyCheckboxes()

                Spacer(modifier = Modifier.height(32.dp))

                MySwitch()

                Spacer(modifier = Modifier.height(32.dp))

                MyRadioButtons()
            }
        }
    }
}



