package by.schools.voronovo.koiapp.ui.common

import android.content.Context
import android.util.TypedValue
import androidx.annotation.StyleRes
import androidx.appcompat.view.ContextThemeWrapper

fun Context.wrap(@StyleRes themeId: Int) = ContextThemeWrapper(this, themeId)

fun Float.toPx(context: Context) : Float = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    context.resources.displayMetrics
)