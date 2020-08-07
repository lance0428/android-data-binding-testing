package com.ldj.databinding.frag

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ldj.databinding.MainViewModel
import com.ldj.databinding.R
import com.ldj.databinding.databinding.FragmentMyBinding
import com.ldj.databinding.list.MyListFragmentActivity

class MyFragment : Fragment() {
    private lateinit var model: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val model: MainViewModel by viewModels()
        this.model = model
        val binding: FragmentMyBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_my,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.model = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.navigation.observe(viewLifecycleOwner, Observer { nav ->
            when (nav) {
                is MainViewModel.Navigation -> startActivity(
                    Intent(
                        requireContext(),
                        MyListFragmentActivity::class.java
                    )
                )
            }
        })
    }
}