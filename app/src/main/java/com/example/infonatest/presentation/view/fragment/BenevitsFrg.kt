package com.example.infonatest.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infonatest.R
import com.example.infonatest.databinding.FragmentBenevitsBinding
import com.example.infonatest.presentation.view.adapter.ParentAdp
import com.example.infonatest.presentation.vm.BenevitsViewModel
import com.example.infonatest.presentation.vm.LoginViewModel

class BenevitsFrg : Fragment() {
    private lateinit var binding: FragmentBenevitsBinding
    private val viewModel: BenevitsViewModel by viewModels()
    private lateinit var adapter: ParentAdp
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBenevitsBinding.inflate(inflater, container, false)
        return binding.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        binding.recyclerParent.layoutManager = LinearLayoutManager(requireContext())
        viewModel.loadBenevits()
        viewModel.adpParent.observe(viewLifecycleOwner){
            adapter = it
            binding.recyclerParent.adapter = it


        }
        binding.shimmerLoad.isVisible = false
        binding.recyclerParent.isVisible = true

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_recycler, menu)
        val searchView = menu.findItem(R.id.actionSearch).actionView as SearchView
        searchView.queryHint = "Buscar.."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(query: String?): Boolean {
                println("Query: $query")
                adapter.filter.filter(query)
                return true
            }
        })
    }

}

