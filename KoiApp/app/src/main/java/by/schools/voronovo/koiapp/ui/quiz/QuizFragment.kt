package by.schools.voronovo.koiapp.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import by.schools.voronovo.koiapp.R
import by.schools.voronovo.koiapp.ui.base.BaseFragment
import by.schools.voronovo.koiapp.ui.common.toPx
import kotlinx.android.synthetic.main.fragment_quiz.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuizFragment : BaseFragment(), NestedScrollView.OnScrollChangeListener {

    companion object {

    }

    val model: QuizViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrollView.setOnScrollChangeListener(this)
        optionsList.isNestedScrollingEnabled = false
    }

    override fun onScrollChange(
        v: NestedScrollView,
        scrollX: Int,
        scrollY: Int,
        oldScrollX: Int,
        oldScrollY: Int
    ) {
        toolbar.elevation = (if (scrollY > 0) 8f else 0f).toPx(v.context)
    }
}
