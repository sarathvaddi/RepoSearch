package com.example.reposearch.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.reposearch.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager!!.
        beginTransaction().
        add(R.id.fragmentContainer,MainViewFragment(),"MVF").commit()
    }
}