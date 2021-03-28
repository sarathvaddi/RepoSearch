package com.example.reposearch.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.reposearch.R
import com.example.reposearch.model.repos


class RepoAdapter(
    private val mRepos: LiveData<List<repos>>?
): RecyclerView.Adapter<RepoViewHolder>() {

    var repos = mRepos


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_repo_details, parent, false)
        return RepoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repos?.value?.get(position)
        holder.title.setText(repo?.full_name)
    }

    override fun getItemCount(): Int {
        return repos?.value?.size!!
    }

}

 class RepoViewHolder(v: View): RecyclerView.ViewHolder(v){
     var title: TextView = v.findViewById(R.id.name)

}


