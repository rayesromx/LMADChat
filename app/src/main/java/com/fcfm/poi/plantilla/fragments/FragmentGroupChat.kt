package com.fcfm.poi.plantilla.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fcfm.poi.plantilla.HomeActivity
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.adapters.ChatAlertAdapter
import com.fcfm.poi.plantilla.adapters.GroupChatAdapter
import com.fcfm.poi.plantilla.models.ChatAlert
import com.fcfm.poi.plantilla.models.GroupChat
import com.fcfm.poi.plantilla.models.Mensaje
import kotlinx.android.synthetic.main.fragment_chat.view.*
import kotlinx.android.synthetic.main.fragment_group_chat.view.*

class FragmentGroupChat : Fragment() {
    private lateinit var rootGroupChatView: View
    private lateinit var groupChatAdapter: GroupChatAdapter
    private val gropuChatList = mutableListOf<GroupChat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootGroupChatView = inflater.inflate(R.layout.fragment_group_chat, container, false)
        //inflater.inflate(R.menu.longpress,rootView);

        loadGroupChats()
        return rootGroupChatView
    }

    private fun loadGroupChats() {
        for (i in 1..10)
            gropuChatList.add(GroupChat("Grupo $i", ""))
        groupChatAdapter = GroupChatAdapter(gropuChatList,
            this.context,
            { view, group -> openActivity(view, group) })
        rootGroupChatView.rvGroupChats.adapter = groupChatAdapter
    }

    fun openActivity(view: View, group: GroupChat) {
        var act = getActivity() as HomeActivity
        act.changeFragment(FragmentGroupChatRoom(), "fragmentGroupChatRoom")
    }
}