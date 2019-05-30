package com.android.navigationjetpack

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_destination.*

class DestinationFragment : Fragment() {
    private lateinit var viewModel: ShareViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_destination, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = DestinationFragmentArgs.fromBundle(arguments!!).name
        val age = DestinationFragmentArgs.fromBundle(arguments!!).age
        welcomeWithNameTv.text = "Hello $name!  \n  Age : $age"
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(ShareViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //2. Observe live data
        viewModel.onValueReceive.observe(this, Observer<String> {
            Log.d("onValueReceive2", it)
        })
        viewModel.setUpdateValue("Data Change!!!!")
    }


}
