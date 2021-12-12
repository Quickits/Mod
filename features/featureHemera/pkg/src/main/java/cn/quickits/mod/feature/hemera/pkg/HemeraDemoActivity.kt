package cn.quickits.mod.feature.hemera.pkg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.quickits.hemera.MainActivity
import cn.quickits.mod.feature.hemera.pkg.databinding.FeatureHemeraActivityMainBinding
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/hemera/main")
class HemeraDemoActivity : AppCompatActivity() {

    private lateinit var binding: FeatureHemeraActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FeatureHemeraActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}