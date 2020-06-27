package com.okcodex.trymvc.screens.postlistactivity

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okcodex.trymvc.R
import com.okcodex.trymvc.model.Post
import com.okcodex.trymvc.screens.common.BaseObservableViewMvc
import com.okcodex.trymvc.screens.common.BaseViewMvc
import com.okcodex.trymvc.screens.common.ObservableViewMvc
import kotlinx.android.synthetic.main.activity_main.*

class PostListViewMvcImpl(layoutInflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<PostListViewMvc.Listener>(), PostListViewMvc, PostAdapter.Listener {


    private var linearLayoutManager: LinearLayoutManager
    private var recyclerView: RecyclerView
    private val mAdapter: PostAdapter


    init {
        setRootView(layoutInflater.inflate(R.layout.activity_main, parent, false))
        recyclerView = findViewId(R.id.recyID)

        linearLayoutManager = LinearLayoutManager(getRootView().context)
        recyclerView.layoutManager = linearLayoutManager


        mAdapter = PostAdapter(layoutInflater)
        recyclerView.adapter = mAdapter
        mAdapter.setListener(this)

    }


    override fun bindData(list: List<Post>) {
        mAdapter.setPostList(list)
        mAdapter.notifyDataSetChanged()
    }

    override fun onPostClicked(post: Post) {
        for (listener in getListener()) {
            listener.onPostClicked(post)
        }
    }

}