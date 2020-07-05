package com.okcodex.trymvc.screens.postDetailsActivity

import android.os.Bundle
import android.widget.Toast
import com.okcodex.trymvc.common.Constants
import com.okcodex.trymvc.model.PostDetailsFetchTask
import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.networking.PostService
import com.okcodex.trymvc.screens.common.BaseActivity
import retrofit2.Call
import retrofit2.Response

class PostDetailsActivity : BaseActivity(), PostDetailsViewMvc.Listener,
    PostDetailsFetchTask.Listener {

    private lateinit var mViewMvc: PostDetailsViewMvc

    private lateinit var fetchTask: PostDetailsFetchTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchTask = getCompositionRoot().getPostDetailsFetchTask()
        mViewMvc = getCompositionRoot().getViewMvcFactory().getPostDetailsViewMvc(null)
        setContentView(mViewMvc.getRootView())
    }

    override fun onStart() {
        super.onStart()
        fetchTask.registerListener(this)
        fetchTask.postDetailsFetched(getPostId())
    }

    override fun onStop() {
        super.onStop()
        fetchTask.unregisterListener(this)
    }

    override fun onPostDetailsLoaded(post: Post) {
        mViewMvc.bindPostDetails(post)
    }

    override fun onPostDetailsLoadFailed() {
        Toast.makeText(this, "failed", Toast.LENGTH_LONG).show()
    }

    private fun getPostId(): Int {
        return intent.getStringExtra(Constants.POST_ID).toInt()
    }

}
