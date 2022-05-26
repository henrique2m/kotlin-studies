package com.example.feedreader

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ItemAdapter(private val list: ArrayList<MainActivity.Item>, private val context: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val author: TextView = view.findViewById(R.id.author)
        val date: TextView = view.findViewById(R.id.date)
        val image: ImageView = view.findViewById(R.id.image)
        val buttonMore: Button = view.findViewById(R.id.button_more)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view);
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.title?.text = list[position].title
        holder.author?.text = list[position].author
        holder.date?.text = SimpleDateFormat(
            "dd/MM/yyyy", Locale(
                "pt",
                "BR"
            )
        ).format(Date(list[position].date))
        holder.buttonMore.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, list[position].link)
            context.startActivity(intent)
        }

        DownloadImageTask(holder.image!!).execute(list[position].image)
    }

    override fun getItemCount(): Int = list.size
}