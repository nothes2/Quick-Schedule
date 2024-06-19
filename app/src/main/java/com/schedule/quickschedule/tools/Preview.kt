package com.schedule.quickschedule.tools

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import com.schedule.quickschedule.ui.activity.LoginActivity
import com.schedule.quickschedule.ui.activity.RegisterActivity

@Preview(
    showBackground = true,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    device = Devices.PIXEL_6,
    showSystemUi = true
)
@Composable
fun Preview() {
    MaterialTheme {
        LoginActivity()
        RegisterActivity()
    }
}