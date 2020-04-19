package tinks.app.readkeeper.common

import java.time.DayOfWeek
import java.util.*

object Utils {
    fun getDateStringFrom(time: Long): String {
        val calendar = Calendar.getInstance().apply { this.time = Date(time) }
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)
    }
}