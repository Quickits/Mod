package cn.quickits.talos.app.lce

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import cn.quickits.talos.app.BaseFragment
import cn.quickits.talos.app.lce.animator.LceAnimator
import cn.quickits.talos.app.lce.animator.MaterialLceAnimator
import cn.quickits.talos.app.lce.data.ErrorData

abstract class LceFragment<VB : ViewBinding, M, VM : LceViewModel<M>, CV : View> :
    BaseFragment<VB>() {

    lateinit var viewModel: VM

    lateinit var loadingView: View
    lateinit var contentView: CV
    lateinit var errorView: TextView

    var lceAnimator: LceAnimator = MaterialLceAnimator()

    abstract fun createViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingView = createLoadingView(view)
        contentView = createContentView(view)
        errorView = createErrorView(view)

        viewModel.loader.observe(viewLifecycleOwner, { pullToRefresh ->
            showLoading(pullToRefresh)
        })

        viewModel.content.observe(viewLifecycleOwner, { content ->
            showContent(content)
        })

        viewModel.error.observe(viewLifecycleOwner, { errorData ->
            showError(errorData)
        })
    }

    protected open fun createLoadingView(view: View): View = view.findViewById(R.id.loading_view)

    protected open fun createContentView(view: View): CV = view.findViewById(R.id.content_view)

    protected open fun createErrorView(view: View): TextView = view.findViewById(R.id.error_view)

    open fun showLoading(pullToRefresh: Boolean?) {
        pullToRefresh ?: return

        if (!pullToRefresh) {
            animateLoadingViewIn()
        }
    }

    open fun showContent(content: M?) {
        content ?: return

        animateContentViewIn()
    }

    open fun showError(errorData: ErrorData?) {
        errorData ?: return

        val ctx = context ?: return

        val msg: CharSequence = getErrorMessage(errorData)

        if (errorData.pullToRefresh) {
            showToastError(msg)
        } else {
            errorView.text = msg

            if (errorData.eIcon != -1) {
                val drawable = ContextCompat.getDrawable(ctx, errorData.eIcon)
                errorView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null,
                    drawable,
                    null,
                    null
                )
            }
            animateErrorViewIn()
        }
    }

    private fun showToastError(msg: CharSequence) {
        if (activity != null) {
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }
    }

    protected open fun getErrorMessage(errorData: ErrorData?): CharSequence {
        errorData ?: return ""
        return errorData.e.message ?: ""
    }

    protected open fun animateLoadingViewIn() {
        lceAnimator.showLoading(loadingView, contentView, errorView)
    }

    protected open fun animateContentViewIn() {
        lceAnimator.showContent(loadingView, contentView, errorView)
    }

    protected open fun animateErrorViewIn() {
        lceAnimator.showErrorView(loadingView, contentView, errorView)
    }

}