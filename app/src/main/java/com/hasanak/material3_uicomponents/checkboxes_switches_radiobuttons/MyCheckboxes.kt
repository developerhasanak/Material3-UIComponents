package com.hasanak.material3_uicomponents.checkboxes_switches_radiobuttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyCheckboxes() {
    val checkBoxes = remember {
        mutableStateListOf(
            ToggleableInfo(
                false,
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

    var triState by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }

    val toggleTriState = {
      triState = when(triState) {
          ToggleableState.Indeterminate -> ToggleableState.On
          ToggleableState.On -> ToggleableState.Off
          else -> ToggleableState.On
      }
        checkBoxes.indices.forEach {index->
            checkBoxes[index] = checkBoxes[index].copy(
                isChecked = triState.equals(ToggleableState.On)
            )
        }

    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                toggleTriState()
            }
            .padding(end = 16.dp)
    ) {
        TriStateCheckbox(
            state = triState,
            onClick = toggleTriState
        )
        
        Text(text = "File types")
    }
    checkBoxes.forEachIndexed { index, toggleableInfo ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                    checkBoxes[index] = toggleableInfo.copy(
                        isChecked = !toggleableInfo.isChecked
                    )
                }
                .padding(end = 16.dp)
        ) {
            Checkbox(checked = toggleableInfo.isChecked,
                onCheckedChange = { isChecked ->
                    checkBoxes[index] = toggleableInfo.copy(
                        isChecked = isChecked
                    )

                }
            )
            Text(text = toggleableInfo.text)
        }
    }

}

data class ToggleableInfo(
    val isChecked: Boolean,
    val text: String
)

@Preview
@Composable
fun MyCheckboxesPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.padding(16.dp)
            .background(Color.White)
    ){
        MyCheckboxes()

    }
}