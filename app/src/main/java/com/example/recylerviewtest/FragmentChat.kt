package com.example.recylerviewtest

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentChat : Fragment() {

    private lateinit var container: ViewGroup
    private lateinit var inflater: LayoutInflater
    private lateinit var activity: Activity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        activity = context as Activity

        this.inflater = inflater
        if (container != null) {
            this.container = container
        }

        return view
    }
}