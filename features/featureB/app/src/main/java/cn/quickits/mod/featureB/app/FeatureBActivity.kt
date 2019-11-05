package cn.quickits.mod.featureB.app

import android.os.Bundle
import cn.quickits.common.app.CommonActivity

class FeatureBActivity : CommonActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = this.javaClass.simpleName
    }
}
