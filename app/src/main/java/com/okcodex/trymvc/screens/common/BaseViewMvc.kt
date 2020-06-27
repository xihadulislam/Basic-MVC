package com.okcodex.trymvc.screens.common

import android.content.Context
import android.view.View


abstract class BaseViewMvc : ViewMvc {

    private lateinit var mRootView: View;

    override fun getRootView(): View {
        return mRootView
    }

    protected open fun setRootView(view: View) {
        this.mRootView = view
    }

    protected fun getContext(): Context {
        return mRootView.context
    }

    protected fun <T : View> findViewId(id: Int): T {
        return mRootView.findViewById(id)
    }


}