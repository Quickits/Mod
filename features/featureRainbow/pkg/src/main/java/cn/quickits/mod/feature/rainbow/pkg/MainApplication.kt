package cn.quickits.mod.feature.rainbow.pkg

import android.app.Application
import cn.quickits.rainbow.Rainbow

/**
 * @author Gavin Liu
 *
 * Created on 2019-11-15.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Rainbow.initThemeOverlays(
            this,
            R.style.ThemeOverlay_PrimaryPalette_Blue,
            R.style.ThemeOverlay_SecondaryPalette_Brown
        )
    }
}