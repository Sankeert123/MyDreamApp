package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spiltwiseclone.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GroupsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
          val rootView: View  = inflater.inflate(R.layout.fragment_groups, container, false)

          return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvGroups = view.findViewById<RecyclerView>(R.id.rv_grp_fragment)
        rvGroups.layoutManager = LinearLayoutManager(activity)
        // val itemSrc = (GroupsItemdData("images/avatars/spunky-sam.png", "Friends", "no expenses"))
        val dataList = listOf(
            GroupsItemdData("https://picsum.photos/seed/picsum/200/300", "Friends", "No expenses"),
            GroupsItemdData("https://via.placeholder.com/300.png/09f/fff","Non - Group expenses", "no expenses"))
        rvGroups.adapter = GroupRVAdapter(dataList)
    }
}