package com.vanced.manager.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.vanced.manager.ui.preferences.holder.managerThemePref

const val defAccentColor = 0xFF0477E1

private val DarkColorPalette = darkColors(
    primary = accentColor,
    primaryVariant = accentColorVariant,
    onSurface = darkOnSurface
)

private val LightColorPalette = lightColors(
    primary = accentColor,
    primaryVariant = accentColorVariant,
    surface = lightSurface,
    onSurface = lightOnSurface
)

@Composable
fun isDark(): Boolean = when (managerThemePref.value.value) {
    "Dark" -> true
    "Light" -> false
    "System Default" -> isSystemInDarkTheme()
    else -> throw IllegalArgumentException("Unknown theme")
}

@Composable
fun ManagerTheme(
    content: @Composable () -> Unit
) {
    val colors = if (isDark()) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}