package com.android.navigationjetpack

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private lateinit var viewModel: ShareViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        buttonWelcomeMe.setOnClickListener{
            val name = enterName.text.toString()
            if(name.isEmpty()) {
                enterName.error = "Please enter a name!"
            } else {
                val action = MainFragmentDirections.actionMainFragmentToDestinationFragment()
                action.age = 25
                action.name = "WWW.ANDROIDCOBAN.COM"
                it.findNavController().navigate(action)
            }
        }
    }

    private fun setupViewModel() {
        //1. Setup ViewModel
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(ShareViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //2. Observe live data
        viewModel.onValueReceive.observe(this, Observer<String> {
            Log.d("onValueReceive1",it)
        })
    }
}
