package com.enesDurmus.myshelf.Fragments

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enesDurmus.myshelf.Adapters.HorizontalAdapter
import com.enesDurmus.myshelf.AppClass
import com.enesDurmus.myshelf.R

/**
 *
 * @author enesdurmus
 */

class HomePageFragment : Fragment() {

    lateinit var _myView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _myView = inflater.inflate(R.layout.fragment_home_page, container, false)

        val recycler1 = _myView?.findViewById<RecyclerView>(R.id.recyclerViewHomePageMovies)

        val recycler2 = _myView?.findViewById<RecyclerView>(R.id.recyclerViewHomePageSeries)

       // val recycler3 = _myView?.findViewById<RecyclerView>(R.id.recyclerViewHomePageBooks)

        if (recycler1 != null && recycler2 != null) {
            recycler1.layoutManager =
                LinearLayoutManager(AppClass.context, LinearLayoutManager.HORIZONTAL, false)

            recycler2.layoutManager =
                LinearLayoutManager(AppClass.context, LinearLayoutManager.HORIZONTAL, false)

            val data: ArrayList<String> = ArrayList()
            data.add("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
            data.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
            data.add("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHw%3D&w=1000&q=80")
            data.add("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
            data.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
            data.add("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHw%3D&w=1000&q=80")
            data.add("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
            data.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
            data.add("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHw%3D&w=1000&q=80")
            recycler1.adapter = HorizontalAdapter(data)
            recycler2.adapter = HorizontalAdapter(data)
        }
        return _myView
    }
}
