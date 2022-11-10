package com.example.app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.RecyclerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentOther : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textViewDesc: TextView = view.findViewById(R.id.custom_text)
        val textViewAuthor: TextView = view.findViewById(R.id.author)
        val textViewData: TextView = view.findViewById(R.id.data)
        arguments?.apply {
            val data = getString("data")
            val author = getString("author")
            val description = getString("description")

            textViewDesc.text = description
            textViewAuthor.text = author
            textViewData.text = data
        }
    }
}