package cn.quickits.talos.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment(), OnBackPressedHandler,
    OnWindowFocusChangedHandler {

    var binding: VB? = null

    private var isStopped = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = createViewBinding(inflater, container, savedInstanceState)
        return binding?.root
    }

    abstract fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VB

    override fun onStart() {
        if (isStopped) {
            onRestart()
            isStopped = false
        }
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        isStopped = true
    }

    open fun onRestart() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar(getSupportActionBar())
    }

    open fun setSupportActionBar(toolbar: Toolbar?) {
        getAppCompatActivity()?.setSupportActionBar(toolbar)
    }

    open fun getAppCompatActivity(): AppCompatActivity? = activity as? AppCompatActivity

    open fun getSupportActionBar(): ActionBar? = getAppCompatActivity()?.supportActionBar

    override fun onBackPressed(): Boolean = false

    open fun setupActionBar(actionBar: ActionBar?) {

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {

    }

}