package com.example.reposearch.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reposearch.R
import com.example.reposearch.model.repos


class RepoAdapter(
    private val context: Context,
    private val mContacts: List<repos>): RecyclerView.Adapter<RepoViewHolder>() {

    var repos = mutableListOf<repos>()

    fun setRepoList(repos: List<repos>) {
        this.repos = repos.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_repo_details, parent, false)
        return RepoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repos[position]
        holder.title.setText(repo.full_name)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

}

 class RepoViewHolder(v: View): RecyclerView.ViewHolder(v){
     var title: TextView = v.findViewById(R.id.name)

}


