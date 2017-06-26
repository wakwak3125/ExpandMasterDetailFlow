package com.wakwak.expandmasterdetailflow

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.wakwak.expandmasterdetailflow.databinding.FragmentRecyclerViewBinding

/**
 * Created by Ryo on 2017/06/25.
 */
class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    private val postRecyclerAdapter by lazy { PostRecyclerViewAdapter() }
    private val layoutManager by lazy { LinearLayoutManager(context) }
    private val verticalHelper by lazy { OrientationHelper.createVerticalHelper(layoutManager) }

    companion object {
        fun newInstance() = RecyclerViewFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = postRecyclerAdapter
        binding.recyclerView.addItemDecoration(divider())

        binding.recyclerView.addOnScrollListener(scrollListener)

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

    private val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val centerView: View? = findCenterView(layoutManager, verticalHelper)
            centerView?.let { v ->
                val bgImage = v.findViewById(R.id.background_image) as ImageView
                binding.backgroundImage.setImageDrawable(bgImage.drawable)
            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        fun findCenterView(layoutManager: RecyclerView.LayoutManager,
                           helper: OrientationHelper): View? {
            val childCount = layoutManager.childCount
            if (childCount == 0) {
                return null
            }

            var closestChild: View? = null
            val center: Int
            if (layoutManager.clipToPadding) {
                center = helper.startAfterPadding + helper.totalSpace / 2
            } else {
                center = helper.end / 2
            }
            var absClosest = Integer.MAX_VALUE

            for (i in 0..childCount - 1) {
                val child = layoutManager.getChildAt(i)
                val childCenter = helper.getDecoratedStart(child) + helper.getDecoratedMeasurement(child) / 2
                val absDistance = Math.abs(childCenter - center)

                /** if child center is closer than previous closest, set it as closest   */
                if (absDistance < absClosest) {
                    absClosest = absDistance
                    closestChild = child
                }
            }
            return closestChild
        }
    }
}
