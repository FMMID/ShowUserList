package com.app.showlistapp.presentation.showlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.showlistapp.databinding.FragmentShowListBinding
import com.app.showlistapp.presentation.ListAdapter
import com.app.showlistapp.presentation.ListItemDecorator
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowListFragment : Fragment() {

    private val viewModel by viewModel<ShowListViewModel>()
    private val listAdapter = ListAdapter()
    private lateinit var binding: FragmentShowListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShowListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showListRecycler.layoutManager = LinearLayoutManager(context)
        binding.showListRecycler.adapter = listAdapter
        binding.showListRecycler.addItemDecoration(ListItemDecorator())
        observe()
        viewModel.fetchListData()
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.showListDataStateFlow
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .distinctUntilChanged()
                .collect { data ->
                    listAdapter.setData(data)
                }

            viewModel.showFailureStateStateFlow
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.RESUMED)
                .distinctUntilChanged()
                .onEach {}
        }
    }
}