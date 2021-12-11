package cn.quickits.mod.feature.rainbow.pkg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cn.quickits.mod.feature.rainbow.pkg.databinding.FeatureRainbowFragmentDemoBinding


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 16:33
 **/
class DemoFragment : Fragment() {

    private var _binding: FeatureRainbowFragmentDemoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FeatureRainbowFragmentDemoBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.toolbar?.let { (activity as AppCompatActivity).setSupportActionBar(it) }
        _binding?.btn?.setOnClickListener { findNavController().navigate(R.id.action_demoFragment_to_themeSwitcherFragment) }
    }

}