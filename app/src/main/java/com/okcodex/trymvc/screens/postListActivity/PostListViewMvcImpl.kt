package com.okcodex.trymvc.screens.postListActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okcodex.trymvc.R
import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.screens.common.BaseObservableViewMvc
import com.okcodex.trymvc.screens.common.ViewMvcFactory

class PostListViewMvcImpl(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    viewMvcFactory: ViewMvcFactory
) :
    BaseObservableViewMvc<PostListViewMvc.Listener>(), PostListViewMvc, PostAdapter.Listener {


    private var linearLayoutManager: LinearLayoutManager
    private var recyclerView: RecyclerView
    private val mAdapter: PostAdapter

    init {
        setRootView(layoutInflater.inflate(R.layout.activity_post_list, parent, false))
        recyclerView = findViewId(R.id.recyID)

        linearLayoutManager = LinearLayoutManager(getRootView().context)
        recyclerView.layoutManager = linearLayoutManager

        mAdapter = PostAdapter(viewMvcFactory)
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