package com.example.myApp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myApp.ui.adapters.GroupRVAdapter
import com.example.myapp.GroupsItemdData
import com.example.myApp.R
import com.example.myApp.databinding.FragmentGroupsBinding

class GroupsFragment : Fragment() {

    private var _binding: FragmentGroupsBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGroupsBinding.inflate(inflater, container, false)
        val rootView = _binding!!.root
        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filterIcon =
            view.findViewById<com.google.android.material.imageview.ShapeableImageView>(
                R.id.groups_filterIcon
            )

        filterIcon.setOnClickListener {

            val popMenu = PopupMenu(context, filterIcon)
            popMenu.inflate(R.menu.groups_filters_menu)

            val menuItemView =
                LayoutInflater.from(context).inflate(R.layout.filter_menu_items, null)
            val radioBtn = menuItemView.findViewById<RadioButton>(R.id.flt_radiobtn)
            val menuTexts =
                menuItemView.findViewById<com.google.android.material.textview.MaterialTextView>(
                    R.id.flt_item_txt
                )
            radioBtn.isChecked = popMenu.menu.getItem(0).isChecked
            popMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.flt_all_groups -> {}
                }
                return@setOnMenuItemClickListener true

            }

            popMenu.show()
        }
        // Setting Recyclerview in the fragment
        val rvGroups = view.findViewById<RecyclerView>(R.id.rv_grp_fragment)
        rvGroups.layoutManager = LinearLayoutManager(activity)

        val dataList = listOf(
            GroupsItemdData("https://picsum.photos/seed/picsum/200/300", "Friends", "No expenses"),
            GroupsItemdData(
                "https://via.placeholder.com/300.png/09f/fff",
                "Non - Group expenses",
                "no expenses"
            )
        )
        rvGroups.adapter = GroupRVAdapter(dataList)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.groups_filters_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}