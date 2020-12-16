package com.vadym.daxxtest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vadym.daxxtest.databinding.NewsListRowBinding
import com.vadym.daxxtest.model.NewsItem
import com.vadym.daxxtest.ui.bindImageFromUrl

class ComplicatedListAdapter(
    private val items: List<NewsItem>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ComplicatedListAdapter.NewsListingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListingViewHolder {
        val view = NewsListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsListingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsListingViewHolder, position: Int) {
        val newsItem = items[position]
        holder.apply { bind(newsItem) }
    }

    inner class NewsListingViewHolder(private val binding: NewsListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsItem) {
            binding.apply {
                newsItem = item
                bindImageFromUrl(binding.newsImageView, item.newsContent.imageThumb)
                binding.newsCard.setOnClickListener { listener.onItemClick(item) }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: NewsItem)
    }

}