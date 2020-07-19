package cn.quickits.mod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.quickits.mod.feature.halia.export.FeatureHaliaRouter
import cn.quickits.mod.feature.rainbow.export.FeatureRainbowRouter
import cn.quickits.routerfit.Routerfit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            Routerfit.create(FeatureHaliaRouter::class.java).launchHaliaDemo()
        }

        button3.setOnClickListener {
            Routerfit.create(FeatureRainbowRouter::class.java).launchRainbowDemo()
        }
    }
}
