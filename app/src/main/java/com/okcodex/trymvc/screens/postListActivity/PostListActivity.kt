package com.okcodex.trymvc.screens.postListActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.okcodex.trymvc.model.PostListFetchTask
import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.screens.common.BaseActivity
import com.okcodex.trymvc.screens.postDetailsActivity.PostDetailsActivity

class PostListActivity : BaseActivity(), PostListViewMvc.Listener, PostListFetchTask.Listener {

    private lateinit var mViewMvc: PostListViewMvc
    private lateinit var fetchTask: PostListFetchTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchTask = getCompositionRoot().getPostListFetchTask()
        mViewMvc = getCompositionRoot().getViewMvcFactory().getPostListViewMvc(null)
        setContentView(mViewMvc.getRootView())

    }

    override fun onStart() {
        super.onStart()
        mViewMvc.registerListener(this)
        fetchTask.registerListener(this)
        fetchTask.postListFetched()
    }

    override fun onStop() {
        super.onStop()
        mViewMvc.unregisterListener(this)
        fetchTask.unregisterListener(this)
    }

    override fun onPostListLoaded(list: List<Post>) {
        mViewMvc.bindData(list)
    }

    override fun onPostListLoadFailed() {
        Toast.makeText(this@PostListActivity, "failed", Toast.LENGTH_LONG).show()
    }

    override fun onPostClicked(post: Post) {
        getCompositionRoot().getScreenNavigator().openPostDetailsActivity(post.id)
    }

}

