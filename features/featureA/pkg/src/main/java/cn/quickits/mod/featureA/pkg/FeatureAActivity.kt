package cn.quickits.mod.featureA.pkg

import android.os.Bundle
import cn.quickits.common.app.CommonActivity
import kotlinx.android.synthetic.main.feature_a_activity_main.*

class FeatureAActivity : CommonActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_a_activity_main)
        title = this.javaClass.simpleName

        button.setOnClickListener {

        }
    }

}