package by.schools.voronovo.koiapp.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import by.schools.voronovo.koiapp.R
import by.schools.voronovo.koiapp.ui.common.obtainStyledAttributes
import kotlinx.android.synthetic.main.view_question_info.view.*

class QuestionInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrRes: Int = R.attr.questionInfoStyle
) : FrameLayout(context, attrs, defAttrRes) {

    companion object {
        const val IMAGE_MODE_SINGLE = 0
        const val IMAGE_MODE_MULTIPLE = 1
    }

    var imageMode: Int = IMAGE_MODE_SINGLE
        set(value) {
            check(value < IMAGE_MODE_SINGLE || value > IMAGE_MODE_MULTIPLE) { "Illegal image mode value!" }
            if(field != value) {
                field = value
                updateImageViewsVisibility()
                invalidate()
            }
        }

    var questionText: String?
        get() = questionTextView.text?.toString()
        set(value) {
            questionTextView.text = value
        }

    var allImagesText: String?
        get() = allImagesTextView.text?.toString()
        set(value) {
            allImagesTextView.text = value
        }

    val prevImages: Sequence<AppCompatImageView?>
        get() = sequence {
            yield(appCompatImageView)
            yield(appCompatImageView2)
            yield(appCompatImageView3)
            yield(appCompatImageView4)
        }

    val singleImage: AppCompatImageView?
        get() = imageView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_question_info, this, true)
        obtainStyledAttributes(
            attrs,
            R.styleable.QuestionInfoView,
            R.attr.questionInfoStyle
        ) { array ->
            imageMode = array.getInt(R.styleable.QuestionInfoView_questionImageMode, 0)
        }
    }

    private fun updateImageViewsVisibility() {
        when(imageMode) {
            IMAGE_MODE_SINGLE -> {
                prevImages.forEach { it?.visibility = View.GONE }
                singleImage?.visibility = View.VISIBLE
            }
            IMAGE_MODE_MULTIPLE -> {
                prevImages.forEach { it?.visibility = View.VISIBLE }
                singleImage?.visibility = View.GONE
            }
        }
    }
}