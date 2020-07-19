package cn.quickits.mod.feature.rainbow.pkg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.quickits.rainbow.Rainbow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Rainbow.applyThemeOverlays(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
