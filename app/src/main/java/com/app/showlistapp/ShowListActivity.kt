package com.app.showlistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.showlistapp.presentation.showlist.ShowListFragment

class ShowListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list_main)

        val startFragment = ShowListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, startFragment)
            .show(startFragment)
            .commitNow()
    }
}