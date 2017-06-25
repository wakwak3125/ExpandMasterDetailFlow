package com.wakwak.expandmasterdetailflow

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wakwak.expandmasterdetailflow.databinding.ItemPostBinding

/**
 * Created by Ryo on 2017/06/25.
 */
class PostRecyclerViewAdapter(var postItems: MutableList<Post> = mutableListOf()) : RecyclerView.Adapter<PostRecyclerViewAdapter.PostViewHolder>() {

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        return PostViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent?.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder?, position: Int) {
        holder?.binding?.post = postItems[position]
        holder?.binding?.executePendingBindings()
    }

    override fun getItemCount(): Int = postItems.size
}
