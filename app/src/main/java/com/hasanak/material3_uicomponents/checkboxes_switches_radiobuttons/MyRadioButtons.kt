package com.hasanak.material3_uicomponents.checkboxes_switches_radiobuttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyRadioButtons() {
    val radioButtons = remember {
        mutableStateListOf(
            ToggleableInfo(
                true,
                "Photos"
            ),
            ToggleableInfo(
                false,
                "Videos"
            ),
            ToggleableInfo(
                false,
                "Audio"
            )
        )
    }

    radioButtons.forEachIndexed { index, toggleableInfo ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier

                .clickable {
                    radioButtons.replaceAll {
                        it.copy(
                            isChecked = it.text == toggleableInfo.text
                        )
                    }
                }
                .padding(end = 16.dp)
        ) {
            RadioButton(selected = toggleableInfo.isChecked,
                onClick = {
                    radioButtons.replaceAll {
                        it.copy(
                            isChecked = it.text == toggleableInfo.text
                        )
                    }
                }
            )
            Text(text = toggleableInfo.text)
        }
    }
}