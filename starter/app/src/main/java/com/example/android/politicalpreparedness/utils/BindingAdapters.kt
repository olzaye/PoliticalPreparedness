package com.example.android.politicalpreparedness.utils

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.android.politicalpreparedness.election.adapter.ElectionListAdapter
import com.example.android.politicalpreparedness.network.models.Election


object BindingAdapters {

    @BindingAdapter("android:liveData")
    @JvmStatic
    fun setRecyclerViewData(recyclerView: RecyclerView, items: LiveData<List<Election>>) {
        items.value?.let { itemList ->
            (recyclerView.adapter as ElectionListAdapter).apply {
                submitList(itemList)
            }
        }
    }
}