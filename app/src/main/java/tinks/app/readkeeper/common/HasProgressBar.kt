package tinks.app.readkeeper.common

import android.view.View
import android.widget.ProgressBar

interface HasProgressBar {
    fun showProgressBar(progressBar: ProgressBar)
    fun hideProgressBar(progressBar: ProgressBar)
}

class BasicProgressBar : HasProgressBar {
    override fun showProgressBar(progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar(progressBar: ProgressBar) {
        progressBar.visibility = View.INVISIBLE
    }

}