package tinks.app.readkeeper

import android.app.Application
import android.content.res.Resources
import android.graphics.drawable.Drawable

class ReadKeeperApplication : Application() {
    companion object {
        lateinit var instance: Application
        lateinit var resourses: Resources
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        resourses = resources
    }


}