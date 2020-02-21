package com.gaurav.newsapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gaurav.newsapp.R
import com.gaurav.newsapp.base.MyApplication
import com.gaurav.newsapp.data.Article
import com.gaurav.newsapp.data.NewsApiResponse
import com.gaurav.newsapp.data.NewsDataRepository
import com.gaurav.newsapp.ui.RecyclerAdapter
import com.gaurav.newsapp.viewmodel.NewsViewModel
import com.gaurav.newsapp.viewmodel.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var newsViewModel: NewsViewModel
    @Inject
    lateinit var newsDataRepository: NewsDataRepository

    /**
     * Injecting via dagger
     * Profit is that we don't need to create every different viewModelFactory class with different params
     */
//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val newsArticlesList = ArrayList<Article>()
    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val factory = NewsViewModelFactory(newsDataRepository)
        newsViewModel =
            ViewModelProvider(this, factory)[NewsViewModel::class.java]
        setupRecyclerView()

        showLoader(true)
        getNewsData()

        swiperefresh.setOnRefreshListener {
            getNewsData()
        }
    }

    private fun setupRecyclerView() {

        val linearLayoutManager = LinearLayoutManager(this)
        rvNews.layoutManager = linearLayoutManager
        recyclerAdapter = RecyclerAdapter(newsArticlesList, this)
        rvNews.adapter = recyclerAdapter
        // for line separation between items
        val dividerItemDecoration =
            DividerItemDecoration(rvNews.context, linearLayoutManager.orientation)
        rvNews.addItemDecoration(dividerItemDecoration)
    }


    private fun getNewsData() {
            newsViewModel.getNewsData().observe(this, Observer<NewsApiResponse> {
                showLoader(false)
        swiperefresh.isRefreshing = false
                if (it != null) {
                    newsViewModel.setNewsArticlesList(it.articles)
                    populateNewsList(it.articles)
                }
            })

    }

    private fun populateNewsList(newData: List<Article>) {
        rvNews.visibility = View.VISIBLE
        recyclerAdapter.updateList(newData)
    }

    /**
     * this start animation when we show the loader
     * clear the animation when we don't show the loader
     */
    private fun showLoader(flag: Boolean) {
        if (flag) {

        } else {

        }
    }
}
