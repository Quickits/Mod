package cn.quickits.mod.feature.rainbow.pkg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.quickits.rainbow.Rainbow
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/rainbow/main")
class RainbowDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Rainbow.applyThemeOverlays(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_rainbow_activity_main)
    }

}
