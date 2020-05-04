package cn.quickits.mod.feature.halia.pkg

import android.os.Bundle
import cn.quickits.arch.base.app.BaseActivity
import kotlinx.android.synthetic.main.activity_halia_demo.*

/**
 * @author Gavin Liu
 *
 * Created on 2020/05/4.
 */
class HaliaDemoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halia_demo)
        button.setOnClickListener {

        }

    }

}