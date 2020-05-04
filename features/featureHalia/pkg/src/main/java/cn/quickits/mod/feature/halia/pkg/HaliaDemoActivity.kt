package cn.quickits.mod.feature.halia.pkg

import android.os.Bundle
import android.util.Log
import cn.quickits.arch.base.app.BaseActivity
import cn.quickits.halia.loading
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
            API.loadingByNetwork()
                .loading()
                .subscribe({ content ->
                    Log.d(HaliaDemoActivity::class.simpleName, content)
                }, { error ->
                    Log.e(HaliaDemoActivity::class.simpleName, error.message ?: "")
                })
        }

    }

}