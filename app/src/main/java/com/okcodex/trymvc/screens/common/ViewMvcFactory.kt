package com.okcodex.trymvc.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.okcodex.trymvc.screens.postDetailsActivity.PostDetailsViewMvc
import com.okcodex.trymvc.screens.postDetailsActivity.PostDetailsViewMvcImpl
import com.okcodex.trymvc.screens.postListActivity.PostListItemViewMvc
import com.okcodex.trymvc.screens.postListActivity.PostListItemViewMvcImpl
import com.okcodex.trymvc.screens.postListActivity.PostListViewMvc
import com.okcodex.trymvc.screens.postListActivity.PostListViewMvcImpl

class ViewMvcFactory(layoutInflater: LayoutInflater) {


    fun getPostListViewMvc(parent: ViewGroup?): PostListViewMvc {
        return PostListViewMvcImpl(mlayoutInflater, parent, this)
    }

    fun getPostItemListViewMvc(parent: ViewGroup?): PostListItemViewMvc {
        return PostListItemViewMvcImpl(mlayoutInflater, parent)
    }

    fun getPostDetailsViewMvc(parent: ViewGroup?): PostDetailsViewMvc {
        return PostDetailsViewMvcImpl(mlayoutInflater, parent)
    }


    private var mlayoutInflater: LayoutInflater

    init {
        mlayoutInflater = layoutInflater
    }

}

