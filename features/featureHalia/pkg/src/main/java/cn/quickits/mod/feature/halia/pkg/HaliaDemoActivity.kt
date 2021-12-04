package cn.quickits.mod.feature.halia.pkg

import android.os.Bundle
import android.util.Log
import cn.quickits.halia.loading
import cn.quickits.mod.feature.halia.pkg.databinding.ActivityHaliaDemoBinding
import cn.quickits.talos.app.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @author Gavin Liu
 *
 * Created on 2020/05/4.
 */
@Route(path = "/halia/main")
class HaliaDemoActivity : BaseActivity() {

    private lateinit var binding: ActivityHaliaDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaliaDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
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