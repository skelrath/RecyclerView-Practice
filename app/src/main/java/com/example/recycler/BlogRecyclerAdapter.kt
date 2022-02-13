package com.example.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recycler.databinding.LayoutBlogListItemBinding
import com.example.recycler.models.BlogPost

class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<BlogPost> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding =
            LayoutBlogListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BlogViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {

            is BlogViewHolder -> holder.bind(items.get(position))

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BlogPost>) {
        items = blogList
    }


    class BlogViewHolder(private val itemBinding: LayoutBlogListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(blogPost: BlogPost) {
            itemBinding.blogTitle.text = blogPost.title
            itemBinding.blogAuthor.text = blogPost.userName


            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(itemBinding.blogImage)
        }

    }

}