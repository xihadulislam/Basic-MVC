package com.okcodex.trymvc.screens.postlistactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okcodex.trymvc.R
import com.okcodex.trymvc.model.Post
import com.okcodex.trymvc.networking.PostService
import com.okcodex.trymvc.networking.ServiceBuilder
import com.okcodex.trymvc.screens.common.BaseActivity
import com.okcodex.trymvc.screens.common.BaseViewMvc
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : BaseActivity(), PostListViewMvc.Listener {

    private lateinit var mviewmvc: PostListViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mviewmvc = getCompositionRoot().getViewMvcFactory().getPostListViewMvc(null)
        setContentView(mviewmvc.getRootView())
        loadData()

    }


    private fun loadData() {


//        val destinationService = ServiceBuilder.buildService(PostService::class.java)
//        val requestCall = destinationService.getPosts()
//
        val requestCall = getCompositionRoot().getPostService().getPosts()


        requestCall.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "failed", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<Post>>, response: Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    val postlist = response.body()!!
                    mviewmvc.bindData(postlist)

                } else {
                    Toast.makeText(this@MainActivity, "failed", Toast.LENGTH_LONG).show()
                }

            }

        })
    }

    
    override fun onStart() {
        super.onStart()
        mviewmvc.registerListener(this)
    }

    override fun onStop() {
        mviewmvc.unregisterListener(this)
        super.onStop()
    }

    override fun onPostClicked(post: Post) {
        Toast.makeText(this, post.title, Toast.LENGTH_SHORT).show()
    }

}

