package by.schools.voronovo.koiapp.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import by.schools.voronovo.koiapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        applyUiFlags()
        setupNavigationUi()

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            toolbar.visibility = View.VISIBLE

        }
    }

    private fun applyUiFlags() {
        var flags = 0

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            flags =
                flags or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            flags =
                flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }

        window.decorView.systemUiVisibility = flags
    }

    private fun setupNavigationUi() {
        val navController = findNavController(R.id.navigationHost)
        val config = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, config)
    }
}
