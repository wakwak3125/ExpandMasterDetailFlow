package com.wakwak.expandmasterdetailflow

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wakwak.expandmasterdetailflow.databinding.FragmentRecyclerViewBinding

/**
 * Created by Ryo on 2017/06/25.
 */
class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    private val postRecyclerAdapter by lazy { PostRecyclerViewAdapter() }

    companion object {
        fun newInstance() = RecyclerViewFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = postRecyclerAdapter
        binding.recyclerView.addItemDecoration(divider())

        updateAdapter()
    }

    private fun updateAdapter() {
        postRecyclerAdapter.postItems.clear()
        postRecyclerAdapter.postItems.addAll(Post.getMockPosts())
        postRecyclerAdapter.notifyDataSetChanged()
    }

    private fun divider(): DividerItemDecoration {
        return DividerItemDecoration(context, LinearLayoutManager.VERTICAL).apply {
            setDrawable(ContextCompat.getDrawable(context, R.drawable.rv_spacer))
        }
    }
}
