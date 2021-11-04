package com.example.myshelf.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.myshelf.AppClass
import com.example.myshelf.R
import okhttp3.*
import java.io.IOException


class SearchPageFragment : Fragment(), AdapterView.OnItemSelectedListener  {

    lateinit var _myView: View
    lateinit var _buttn: Button
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _myView = inflater.inflate(R.layout.fragment_search_page, container, false)
        _buttn = _myView.findViewById(R.id.button)

        _buttn.setOnClickListener{
            val request = Request.Builder()
                .url("https://imdb-api.com/en/API/SearchTitle/k_qhp4wjps/Lord Of The Rings")
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {}
                override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
            })
        }

        val spinner : Spinner = _myView.findViewById<Spinner>(R.id.spinnerSearchPage)
        AppClass.context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.search_options,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinner.adapter = adapter
            }
        }

        spinner.onItemSelectedListener = this

        return _myView
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("naber", "naber")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}