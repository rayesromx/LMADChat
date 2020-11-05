package com.fcfm.poi.plantilla.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fcfm.poi.plantilla.HomeActivity
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.adapters.ChatAlertAdapter
import com.fcfm.poi.plantilla.models.ChatAlert
import kotlinx.android.synthetic.main.fragment_chat.view.*

class FragmentChat: Fragment() {

    private lateinit var rootChatView: View
    private lateinit var alertChatAdapter: ChatAlertAdapter
    private val alertChatList = mutableListOf<ChatAlert>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootChatView = inflater.inflate(R.layout.fragment_chat, container, false)
        loadChatsAlerts()
        return rootChatView
    }

    /****
     * La idea es que aqui consulten los chats pendientes del usuario de la base de datos y lo cargen en el adaptador
     *****/

    private fun loadChatsAlerts() {

        for (i in 0..10)
            alertChatList.add(ChatAlert("Usuario $i", "Notifica: Hola, que onda", ""))

        alertChatAdapter = ChatAlertAdapter(
            alertChatList,
            this.context,
            { view, chat -> openActivity(view, chat) })
        rootChatView.rvChats.adapter = alertChatAdapter
    }

    fun openActivity(view: View, chat: ChatAlert) {
        var act = getActivity() as HomeActivity
        act.changeFragment(FragmentChatRoom(), "fragmentChatRoom")
    }
}