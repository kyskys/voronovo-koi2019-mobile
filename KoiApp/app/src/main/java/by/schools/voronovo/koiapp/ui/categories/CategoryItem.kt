package by.schools.voronovo.koiapp.ui.categories

import android.view.View
import by.schools.voronovo.koiapp.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_category.*

class CategoryItem(
    private val title: String,
    private val path: String,
    private val callback: Callback
) : Item(), View.OnClickListener {
    override fun getLayout(): Int = R.layout.item_category

    override fun bind(viewHolder: ViewHolder, position: Int) = viewHolder.run {
        textView.text = title
        containerView.setOnClickListener(this@CategoryItem)
    }

    override fun unbind(viewHolder: ViewHolder) {
        super.unbind(viewHolder)
        viewHolder.containerView.setOnClickListener(null)
    }

    override fun onClick(p0: View?) {
        callback.onCategoryClick(title, path)
    }

    interface Callback {
        fun onCategoryClick(title: String, path: String)
    }
}