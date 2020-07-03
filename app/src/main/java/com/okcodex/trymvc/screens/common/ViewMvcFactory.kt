package com.okcodex.trymvc.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.okcodex.trymvc.screens.postlistactivity.PostListItemViewMvc
import com.okcodex.trymvc.screens.postlistactivity.PostListItemViewMvcImpl
import com.okcodex.trymvc.screens.postlistactivity.PostListViewMvc
import com.okcodex.trymvc.screens.postlistactivity.PostListViewMvcImpl

class ViewMvcFactory(layoutInflater: LayoutInflater) {


    fun getPostListViewMvc(parent: ViewGroup?): PostListViewMvc {
        return PostListViewMvcImpl(mlayoutInflater, parent,this)
    }

    fun  getPostItemListViewMvc(parent: ViewGroup?) : PostListItemViewMvc {
        return  PostListItemViewMvcImpl(mlayoutInflater,parent)
    }

    private var mlayoutInflater: LayoutInflater

    init {
        mlayoutInflater = layoutInflater
    }

}

