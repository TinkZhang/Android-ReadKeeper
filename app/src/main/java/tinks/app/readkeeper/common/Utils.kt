package tinks.app.readkeeper.common

import android.animation.Animator
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.view.ViewCompat
import tinks.app.readkeeper.ReadKeeperApplication
import java.util.*

object Utils {
    fun getDateStringFrom(time: Long): String {
        val calendar = Calendar.getInstance().apply { this.time = Date(time) }
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)
    }

    fun tintDrawableWithStateList(
        @DrawableRes drawableId: Int,
        @ColorRes colorStateListId: Int
    ): Drawable? {
        var drawable: Drawable? =
            ReadKeeperApplication.instance.baseContext.getDrawable(drawableId)
        if (drawable != null) {
            drawable = drawable.mutate()
            drawable.setTintList(
                ReadKeeperApplication.instance.baseContext.getColorStateList(colorStateListId)
            )
            drawable.setTintMode(PorterDuff.Mode.SRC_ATOP)
        }
        return drawable
    }

    fun throb(view: View) {
        clear(view)
        view.animate()
            .scaleX(1.3f)
            .scaleY(1.3f)
            .setDuration(100)
            .setListener(
                object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {}
                    override fun onAnimationEnd(animation: Animator) {
                        view.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(50)
                            .setListener(null)
                            .start()
                    }

                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                }).start()
    }

    private fun clear(v: View) {
        ViewCompat.setAlpha(v, 1f)
        ViewCompat.setScaleY(v, 1f)
        ViewCompat.setScaleX(v, 1f)
        ViewCompat.setTranslationY(v, 0f)
        ViewCompat.setTranslationX(v, 0f)
        ViewCompat.setRotation(v, 0f)
        ViewCompat.setRotationY(v, 0f)
        ViewCompat.setRotationX(v, 0f)
        ViewCompat.setPivotY(v, v.measuredHeight / 2.toFloat())
        ViewCompat.setPivotX(v, v.measuredWidth / 2.toFloat())
        v.animate().setListener(null).setInterpolator(null).cancel()
    }
}