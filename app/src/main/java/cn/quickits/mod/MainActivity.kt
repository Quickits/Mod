package cn.quickits.mod

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cn.quickits.mod.databinding.ActivityMainBinding
import cn.quickits.mod.feature.halia.export.FeatureHaliaRouter
import cn.quickits.mod.feature.hemera.export.FeatureHemeraRouter
import cn.quickits.mod.feature.rainbow.export.FeatureRainbowRouter
import cn.quickits.routerfit.Routerfit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            Routerfit.create(FeatureHaliaRouter::class.java).launchHaliaDemo()
        }

        binding.button2.setOnClickListener {
            Routerfit.create(FeatureRainbowRouter::class.java).launchRainbowDemo()
        }

        binding.button3.setOnClickListener {
            Routerfit.create(FeatureHemeraRouter::class.java).launchHemeraDemo()
        }
    }
}
