package cn.quickits.mod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.quickits.mod.featureA.export.FeatureARouter
import cn.quickits.routerfit.Routerfit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_a_activity_main)

        button.setOnClickListener {
            Routerfit.create(FeatureARouter::class.java).launchFeatureA()
        }
    }
}
