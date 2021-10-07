package com.example.recylerviewtest

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentBookmark : Fragment() {

    private lateinit var container: ViewGroup
    private lateinit var inflater: LayoutInflater
    private lateinit var activity: Activity

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookmark, container, false)
        activity = context as Activity

        this.inflater = inflater
        if (container != null) {
            this.container = container
        }

        val bookmarkList = ArrayList<BookmarkData>()
        bookmarkList.add(BookmarkData(RecyclerViewAdapter.VIEW_TYPE_TEXT, "안녕", null))
        bookmarkList.add(BookmarkData(RecyclerViewAdapter.VIEW_TYPE_IMAGE, null, "http://wiki.hash.kr/images/4/45/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C_%EB%A1%9C%EA%B3%A0.png"))

        val recyclerViewAdapter = RecyclerViewAdapter(activity, bookmarkList)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = recyclerViewAdapter

        return view
    }
}