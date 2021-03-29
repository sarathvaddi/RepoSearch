package com.example.reposearch.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reposearch.R
import com.example.reposearch.model.Repos


class RepoAdapter(
    private var mRepos: List<Repos>?
): RecyclerView.Adapter<RepoViewHolder>() {

    //var repos = mRepos


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_repo_details, parent, false)
        return RepoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = mRepos?.get(position)
        holder.title.setText(repo?.full_name)
    }

    override fun getItemCount(): Int {
        if(mRepos!=null)
        return mRepos?.size!!
        else
            return 0
    }

     fun setItems(Repos :List<Repos>) {
         this.mRepos = Repos
     }

}

 class RepoViewHolder(v: View): RecyclerView.ViewHolder(v){
     var title: TextView = v.findViewById(R.id.name)

}


