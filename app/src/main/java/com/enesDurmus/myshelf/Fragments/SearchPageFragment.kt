package com.enesDurmus.myshelf.Fragments

import SearchViewAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enesDurmus.myshelf.AppClass
import com.enesDurmus.myshelf.Adapters.HorizontalAdapter
import com.enesDurmus.myshelf.ItemsViewModel
import com.enesDurmus.myshelf.R
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.ArrayList

enum class CallState {
    Waiting, Ended, NotStarted
}

class SearchPageFragment : Fragment(), AdapterView.OnItemSelectedListener {

    lateinit var _myView: View
    lateinit var _buttn: Button
    lateinit var _searchText: EditText
    private val client = OkHttpClient()
    lateinit var _recylerView: RecyclerView
    private var _callState = CallState.NotStarted


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
        _recylerView = _myView.findViewById(R.id.recyclerViewSearchPage)
        _searchText = _myView.findViewById(R.id.textSearchPage)

        val data = ArrayList<ItemsViewModel>()

       // if (_recylerView != null) {
            _recylerView.layoutManager =
                LinearLayoutManager(AppClass.context, LinearLayoutManager.VERTICAL, false)

       //     data.add("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
       //     data.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
      //      data.add("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHw%3D&w=1000&q=80")
      ///      _recylerView.adapter = HorizontalAdapter(data)
     //   }

        _buttn.setOnClickListener {
            val request = Request.Builder()
                .url("https://api.themoviedb.org/3/search/movie?api_key=8ba2fa79d6e283bcac0b5cb565119a92&query=" + _searchText.text)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {}
                override fun onResponse(call: Call, response: Response) {
                    val jsonObj = JSONObject(response.body()?.string())
                    val map = jsonObj.toMap()
                    val liste = map.getValue("results") as ArrayList<HashMap<String, String>>
                    Log.d("denem1", liste[0].toString())

                    for (x in liste) {
                        data.add(ItemsViewModel("https://image.tmdb.org/t/p/original" + x.getValue("poster_path"), x.getValue("original_title")))
                       // x.get("original_title".toString())?.let { it1 -> Log.d("sea", it1) }
                    }

                 //   val adapter = HorizontalAdapter(data)
               //     recycler1.layoutManager = LinearLayoutManager(AppClass.context)
                //    recycler1.adapter = adapter

                /*    if (recycler1 != null) {
                        recycler1.layoutManager =
                            LinearLayoutManager(AppClass.context, LinearLayoutManager.VERTICAL, false)
                    }

                    recycler1.adapter = HorizontalAdapter(data)*/
                    addData(data)
                    _callState = CallState.Ended
                }
            })
        }



        val spinner: Spinner = _myView.findViewById<Spinner>(R.id.spinnerSearchPage)
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

    fun JSONObject.toMap(): Map<String, *> = keys().asSequence().associateWith {
        when (val value = this[it]) {
            is JSONArray -> {
                val map = (0 until value.length()).associate { Pair(it.toString(), value[it]) }
                JSONObject(map).toMap().values.toList()
            }
            is JSONObject -> value.toMap()
            JSONObject.NULL -> null
            else -> value
        }
    }

    fun addData(data: ArrayList<ItemsViewModel>){
        //data.clear()

        Thread(Runnable {
            // try to touch View of UI thread
            this@SearchPageFragment.activity?.runOnUiThread(java.lang.Runnable {
                _recylerView.adapter = SearchViewAdapter(data)
            })
        }).start()

    }
}