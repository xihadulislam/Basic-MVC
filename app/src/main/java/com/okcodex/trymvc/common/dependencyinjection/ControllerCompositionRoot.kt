package com.okcodex.trymvc.common.dependencyinjection

import android.app.Activity
import android.view.LayoutInflater
import com.okcodex.trymvc.networking.PostService
import com.okcodex.trymvc.screens.common.ViewMvcFactory

class ControllerCompositionRoot(compositionRoot: CompositionRoot, activity: Activity) {


    private val mCompositionRoot: CompositionRoot
    private val mActivity: Activity

    init {
        mCompositionRoot = compositionRoot
        mActivity = activity
    }


    fun getPostService(): PostService {
        return mCompositionRoot.getPostService()
    }

    private fun getLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(mActivity)
    }

    fun getViewMvcFactory(): ViewMvcFactory {
        return ViewMvcFactory(getLayoutInflater())

    }

}