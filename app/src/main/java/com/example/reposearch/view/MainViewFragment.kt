package com.example.reposearch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reposearch.R
import com.example.reposearch.databinding.MainViewFragmentBinding
import com.example.reposearch.viewmodel.RepoViewModel

class MainViewFragment : Fragment(){
    private lateinit var viewModel : RepoViewModel
    private lateinit var adapter: RepoAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.main_view_fragment, container, false)
        viewModel = activity?.run { ViewModelProviders.of(this)[RepoViewModel::class.java] } ?: throw Exception("Invalid Activity")
        val binding: MainViewFragmentBinding = DataBindingUtil.setContentView(this.activity!!, R.layout.main_view_fragment)

        binding.recyclerview?.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        )

        binding.searchButton.setOnClickListener{

            var list = viewModel.getUser(binding.searchView.text.toString())?.observe(viewLifecycleOwner,
                Observer {
                    adapter.setItems(it)
                    adapter.notifyDataSetChanged()
                })
            adapter = RepoAdapter(mutableListOf())
            binding.recyclerview.adapter = adapter

        }

//        viewModel.servicesLiveData?.observe(viewLifecycleOwner, Observer {
//            adapter.setItems(it)
//            adapter.notifyDataSetChanged()
//        })

        val fm = fragmentManager

//        fm!!.beginTransaction()
//            .replace(R.id.fragmentContainer,WebViewFragment(),"FragmentTwo")
//            .addToBackStack(null).commit()
        return rootView
    }
}