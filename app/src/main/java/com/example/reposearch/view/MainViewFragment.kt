package com.example.reposearch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reposearch.R
import com.example.reposearch.viewmodel.RepoViewModel
import kotlinx.android.synthetic.main.main_view_fragment.*

class MainViewFragment : Fragment(){
    private lateinit var searchButton: Button
    private lateinit var searchView : SearchView
    private lateinit var viewModel : RepoViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.main_view_fragment, container, false)
        viewModel = activity?.run { ViewModelProviders.of(this)[RepoViewModel::class.java] } ?: throw Exception("Invalid Activity")
        searchButton = rootView.findViewById(R.id.search_button)
        searchView = rootView.findViewById(R.id.search_view)

        recyclerview!!.layoutManager = LinearLayoutManager(context)
        recyclerview.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        )

        searchButton.setOnClickListener{
           recyclerview.adapter = RepoAdapter(viewModel.getUser(searchView.query.toString()))

        }

        val fm = fragmentManager

        fm!!.beginTransaction()
            .replace(R.id.fragmentContainer,WebViewFragment(),"FragmentTwo")
            .addToBackStack(null).commit()
        return rootView
    }
}