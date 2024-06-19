package com.schedule.quickschedule.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.schedule.quickschedule.database.Event

@Composable
fun EventListItem(event: Event, modifier: Modifier = Modifier) {
    Row (modifier = modifier
        .fillMaxWidth()
        .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically){
        Checkbox(checked = event.checked, onCheckedChange = {})
        Column {
            Text(text = event.title, fontSize = 18.sp)
            Text(text = event.context, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Column {
            Icon(Icons.Default.MoreVert, contentDescription = null)
        }
    }
}