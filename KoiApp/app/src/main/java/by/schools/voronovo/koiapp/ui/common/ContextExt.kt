package by.schools.voronovo.koiapp.ui.common

import android.content.Context
import androidx.annotation.StyleRes
import androidx.appcompat.view.ContextThemeWrapper

fun Context.wrap(@StyleRes themeId: Int) = ContextThemeWrapper(this, themeId)