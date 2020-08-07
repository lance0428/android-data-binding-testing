package com.ldj.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count: Int = 0
    val text = MutableLiveData<String>()
    val navigation = SingleLiveEvent<Navigation>()

    private fun setValue() {
        text.value = "You clicked me $count"
    }

    fun buttonClicked() {
        count++
        setValue()
    }

    fun launchFragmentActivityClicked() {
        navigation.value = Navigation.LaunchActivityFragment
    }

    fun launchFragmentListActivityClicked() {
        navigation.value = Navigation.LaunchActivityFragmentList
    }

    sealed class Navigation {
        object LaunchActivityFragment : Navigation()
        object LaunchActivityFragmentList : Navigation()
    }
}