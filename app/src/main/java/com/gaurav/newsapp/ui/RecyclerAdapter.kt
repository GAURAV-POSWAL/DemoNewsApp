package com.gaurav.newsapp.ui

import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.gaurav.newsapp.R
import com.gaurav.newsapp.data.Article
import com.gaurav.newsapp.data.NewsApiResponse
import java.util.*
import kotlin.collections.ArrayList


class RecyclerAdapter(private val newsList: ArrayList<Article>) :
    RecyclerView.Adapter<RecyclerAdapter.WeatherHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val inflatedView = parent.inflate(R.layout.adapter_news, false)
        return WeatherHolder(inflatedView)
    }

    override fun getItemCount() = newsList.size

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        if (newsList.size > 0) {

            val itemPhoto = newsList[position]
            holder.bindPhoto(itemPhoto)
        }
    }

    fun updateList(newData: ArrayList<Article>) {
        newsList.clear()
        newsList.addAll(newData)
        notifyDataSetChanged()

    }


    class WeatherHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private lateinit var newsArticle: Article
        private var view: View = v

        init {

            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d("RecyclerView", "CLICK!")
        }

        fun bindPhoto(newsArticle: Article) {
            this.newsArticle = newsArticle
        }


        private fun getDayNameFromTimeStamp(timeStamp: Long): String {

            val calendar = Calendar.getInstance(Locale.ENGLISH)
            calendar.timeInMillis = timeStamp * 1000L
            return DateFormat.format("EEEE", calendar).toString()
        }
    }


}

private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

