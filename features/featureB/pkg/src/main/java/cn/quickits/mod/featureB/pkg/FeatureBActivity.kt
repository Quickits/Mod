package cn.quickits.mod.featureB.pkg

import android.os.Bundle
import cn.quickits.talos.app.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/featureB/main")
class FeatureBActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_b_activity_main)
        title = this.javaClass.simpleName
    }
}
