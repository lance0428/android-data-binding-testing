package com.ldj.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ldj.databinding.databinding.FragmentMyListBinding
import kotlinx.android.synthetic.main.fragment_my_list.*

class MyListFragment : Fragment() {
    private lateinit var model: MyListViewModel

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MyListAdapter()
        list.adapter = adapter
        model.data.observe(viewLifecycleOwner, Observer { data ->
            adapter.submitList(data)
        })
    }
}