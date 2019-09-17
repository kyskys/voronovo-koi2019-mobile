package by.schools.voronovo.koiapp.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.schools.voronovo.koiapp.R
import by.schools.voronovo.koiapp.model.CategoryInfo
import by.schools.voronovo.koiapp.ui.base.BaseFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.fragment_categories.*
import java.util.*

class CategoriesFragment : BaseFragment(), View.OnClickListener {

    companion object {

    }

    private val categories = LinkedList<CategoryInfo>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = GroupAdapter<ViewHolder>()
        recyclerView.addOnScrollListener()

        view.findNavController().let { controller ->
            toolbar.setupWithNavController(controller, AppBarConfiguration(controller.graph))
        }
    }

    private fun onNewCategory(categoryInfo: CategoryInfo) {
        toolbar.title = categoryInfo.title ?: getString(R.string.categories_title)
        chipsGroup.addCategoryChip(categoryInfo.title ?: "/")
    }

    private fun ChipGroup.addCategoryChip(title: String) {
        (layoutInflater.inflate(R.layout.view_category_path_segment, this, false) as? Chip)?.apply {
            text = title
            isCloseIconVisible = false
            isClickable = true
            isCheckable = false
            setOnClickListener(this@CategoriesFragment)
            this@addCategoryChip.addView(this)
        }
    }

    override fun onClick(view: View?) {
        if (view is Chip) {
            revertCategories(view)
        }
    }

    private fun revertCategories(view: Chip) {
        val index = chipsGroup.indexOfChild(view)

        if (index == -1) return

        chipsGroup.removeViews(index + 1, chipsGroup.childCount - index)
        categories.subList(index, categories.lastIndex).clear()
        onNewCategory(categories.last)
    }
}