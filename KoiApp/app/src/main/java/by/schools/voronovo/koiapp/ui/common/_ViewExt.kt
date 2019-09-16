package by.schools.voronovo.koiapp.ui.common

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View

inline fun View.obtainStyledAttributes(
    set: AttributeSet?,
    attrs: IntArray,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
    action: (TypedArray) -> Unit
) {
    if (set != null) {
        val array = context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes)
        action(array)
        array.recycle()
    }
}