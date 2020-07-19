package cn.quickits.mod.feature.rainbow.pkg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.feature_rainbow_fragment_demo.*


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 16:33
 **/
class DemoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.feature_rainbow_fragment_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        btn.setOnClickListener { findNavController().navigate(R.id.action_demoFragment_to_themeSwitcherFragment) }
    }

}