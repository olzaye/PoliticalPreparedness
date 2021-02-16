package com.example.android.politicalpreparedness.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.android.politicalpreparedness.election.adapter.ElectionListAdapter
import com.example.android.politicalpreparedness.network.models.Election
import java.text.DateFormat
import java.util.*


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

    @BindingAdapter("android:setDateAsText")
    @JvmStatic
    fun setDateAsText(view: TextView, date: Date) {
        val dateFormat = DateFormat.getDateInstance().format(date)
       view.text = dateFormat
    }
}