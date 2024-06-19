package com.schedule.quickschedule.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.schedule.quickschedule.ui.viewmodel.TaskModel


@Composable
@ExperimentalMaterial3Api
fun AddDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    onCancel: () -> Unit,
    dialogTitle: String,
    viewModel: TaskModel,
    modifier: Modifier = Modifier,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card (
            modifier
                .fillMaxSize()
                .padding(16.dp)){
            Text(text = dialogTitle, fontSize = 24.sp, modifier = modifier.padding(5.dp))
            OutlinedTextField(value = viewModel.task.title,
                onValueChange = { viewModel.task = viewModel.task.copy(title = it) },
                label = { Text(text = "Title") },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp))
            OutlinedTextField(value = viewModel.task.context,
                onValueChange = {viewModel.task = viewModel.task.copy(context = it)},
                label = { Text(text = "Describe") },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp))
            Row (
                modifier
                    .fillMaxWidth()
                    .padding(5.dp)){
                IconButton(onClick = onConfirmation, modifier.weight(1f)) {
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Icon(Icons.Default.Done, contentDescription = null)
                        Spacer(modifier = modifier.width(10.dp))
                        Text(text = "YES!")
                    }

                }

                OutlinedIconButton(onClick = onCancel, modifier.weight(1f)) {
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Icon(Icons.Default.Clear, contentDescription = null)
                        Spacer(modifier = modifier.width(10.dp))
                        Text(text = "Nah!")
                    }
                }
            }
        }
    }
}
