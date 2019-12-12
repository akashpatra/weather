package com.akash.weather.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 * BaseFragment for all fragments in the app.
 *
 * @author Akash Patra
 */
abstract class BaseFragment : Fragment() {

    private var mActivity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            mActivity = context
        }
        injectDependencies(mActivity)
    }

    protected abstract fun injectDependencies(baseActivity: BaseActivity?)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    protected abstract fun setUp(view: View)

    protected fun showSnackBar(view: View, msg: String) {
        val snackBar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
        snackBar.view.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        snackBar.show()
    }

    override fun onDetach() {
        super.onDetach()
        mActivity = null
    }
}
