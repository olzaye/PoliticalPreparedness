package com.example.android.politicalpreparedness.election.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.politicalpreparedness.databinding.ViewHolderElectionBinding
import com.example.android.politicalpreparedness.network.models.Election

class ElectionListAdapter(private val clickListener: ElectionListener) :
        ListAdapter<Election, ElectionViewHolder>(ElectionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectionViewHolder {
        return ElectionViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ElectionViewHolder, position: Int) {
        holder.binding.election = getItem(position)
    }
}

class ElectionViewHolder(val binding: ViewHolderElectionBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): ElectionViewHolder {
            return ElectionViewHolder(ViewHolderElectionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    null,
                    false))
        }
    }
}

//TODO: Create ElectionDiffCallback

class ElectionDiffCallback : DiffUtil.ItemCallback<Election>() {
    override fun areItemsTheSame(oldItem: Election, newItem: Election): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Election, newItem: Election): Boolean {
        TODO("Not yet implemented")
    }
}

//TODO: Create ElectionListener
interface ElectionListener {
}