package com.bitrise.addly.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.bitrise.addly.R

private val DarkColorPalette = darkColors(
        primary = Purple200,
        primaryVariant = Purple700,
        secondary = Teal200
)

private val LightColorPalette = lightColors(
        primary = Purple500,
        primaryVariant = Purple700,
        secondary = Teal200

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AddlyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val appFontFamily = FontFamily(
        fonts = listOf(
            Font(
                resId = R.font.sourcecodepro_medium,
                weight = FontWeight.W900,
                style = FontStyle.Normal
            ),
            Font(
                resId = R.font.sourcecodepro_medium,
                weight = FontWeight.W900,
                style = FontStyle.Italic
            ),
            Font(
                resId = R.font.sourcecodepro_bold,
                weight = FontWeight.W700,
                style = FontStyle.Normal
            ),
    )
    )

     val defaultTypography = Typography()
    val appTypography = Typography(
        h1 = defaultTypography.h1.copy(fontFamily = appFontFamily),
        h2 = defaultTypography.h2.copy(fontFamily = appFontFamily),
        h3 = defaultTypography.h3.copy(fontFamily = appFontFamily),
        h4 = defaultTypography.h4.copy(fontFamily = appFontFamily),
        h5 = defaultTypography.h5.copy(fontFamily = appFontFamily),
        h6 = defaultTypography.h6.copy(fontFamily = appFontFamily),
        subtitle1 = defaultTypography.subtitle1.copy(fontFamily = appFontFamily),
        subtitle2 = defaultTypography.subtitle2.copy(fontFamily = appFontFamily),
        body1 = defaultTypography.body1.copy(fontFamily = appFontFamily),
        body2 = defaultTypography.body2.copy(fontFamily = appFontFamily),
        button = defaultTypography.button.copy(fontFamily = appFontFamily),
        caption = defaultTypography.caption.copy(fontFamily = appFontFamily),
        overline = defaultTypography.overline.copy(fontFamily = appFontFamily)
    )


    MaterialTheme(
            colors = colors,
            typography = appTypography,
            shapes = Shapes,
            content = content
    )
}