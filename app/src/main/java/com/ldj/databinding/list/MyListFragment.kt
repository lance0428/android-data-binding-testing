package com.ldj.databinding.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ldj.databinding.R
import com.ldj.databinding.databinding.FragmentMyListBinding

class MyListFragment : Fragment() {
    private lateinit var model: MyListViewModel
    private lateinit var adapter: MyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val model: MyListViewModel by viewModels()
        this.model = model
        val binding: FragmentMyListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_my_list,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.model = model
        adapter = MyListAdapter()
        binding.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.data.observe(viewLifecycleOwner, Observer { data ->
            adapter.submitList(data)
        })
    }
}