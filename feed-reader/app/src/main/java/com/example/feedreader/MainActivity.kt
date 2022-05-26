package com.example.feedreader

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback

import  com.pkmmte.pkrss.PkRSS

class MainActivity : AppCompatActivity(), Callback {
    private lateinit var listView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>

    private val listItems = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = LinearLayoutManager(this)

        listView = findViewById(R.id.recycler_view)
        listView.layoutManager = layout

        adapter = ItemAdapter(listItems, this)
        listView.adapter = adapter


        PkRSS.with(this).load("https://rss.tecmundo.com.br/feed").callback(this).async()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onLoaded(newArticles: MutableList<Article>?) {
        listItems.clone()
        newArticles?.mapTo(listItems) {
            Item(it.title, it.author, it.date, it.source, it.enclosure.url)
        }

        adapter.notifyDataSetChanged()

    }

    override fun onLoadFailed() {
    }

    override fun onPreload() {
    }


    data class Item(
        val title: String,
        val author: String,
        val date: Long,
        val link: Uri,
        val image: String
    )


}