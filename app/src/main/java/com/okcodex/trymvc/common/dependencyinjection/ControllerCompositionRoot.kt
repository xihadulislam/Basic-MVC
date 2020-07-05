package com.okcodex.trymvc.common.dependencyinjection

import android.app.Activity
import android.view.LayoutInflater
import com.okcodex.trymvc.model.PostDetailsFetchTask
import com.okcodex.trymvc.model.PostListFetchTask
import com.okcodex.trymvc.networking.PostService
import com.okcodex.trymvc.screens.common.ScreenNavigator
import com.okcodex.trymvc.screens.common.ViewMvcFactory

class ControllerCompositionRoot(compositionRoot: CompositionRoot, activity: Activity) {


    private val mCompositionRoot: CompositionRoot
    private val mActivity: Activity

    init {
        mCompositionRoot = compositionRoot
        mActivity = activity
    }


    private fun getPostService(): PostService {
        return mCompositionRoot.getPostService()
    }

    private fun getLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(mActivity)
    }

    fun getViewMvcFactory(): ViewMvcFactory {
        return ViewMvcFactory(getLayoutInflater())

    }

    fun getScreenNavigator(): ScreenNavigator {
        return ScreenNavigator(mActivity)
    }


    fun getPostDetailsFetchTask(): PostDetailsFetchTask {
        return PostDetailsFetchTask(getPostService())
    }

    fun getPostListFetchTask(): PostListFetchTask {

        return PostListFetchTask(getPostService())
    }


}