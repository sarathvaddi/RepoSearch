package com.example.reposearch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.reposearch.R
import com.example.reposearch.retrofit.RetrofitClient
import com.example.reposearch.viewmodel.RepoViewModel

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

        searchButton.setOnClickListener{
           viewModel.getUser(searchView.query.toString())
        }

        val fm = fragmentManager

        fm!!.beginTransaction()
            .replace(R.id.fragmentContainer,WebViewFragment(),"FragmentTwo")
            .addToBackStack(null).commit()
        return rootView
    }
}