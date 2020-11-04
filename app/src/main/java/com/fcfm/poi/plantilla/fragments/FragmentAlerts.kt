package com.fcfm.poi.plantilla.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.adapters.AlertAdapter
import com.fcfm.poi.plantilla.models.Alert
import kotlinx.android.synthetic.main.fragment_alerts.view.*

class FragmentAlerts : Fragment() {

    private lateinit var rootView: View
    private lateinit var alertAdapter: AlertAdapter
    private val alertList = mutableListOf<Alert>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_alerts, container, false)
        //inflater.inflate(R.menu.longpress,rootView);

        loadAlerts()
        return rootView
    }

    /**
     * La idea es que aqui consulten las alertas pendientes del usuario de la base de datos y lo cargen en el adaptador
     * */
    private fun loadAlerts() {

        for (i in 0..10)
            alertList.add(Alert("Alerta $i", "Notifica: Alerta #$i", ""))

        alertAdapter = AlertAdapter(alertList)
        rootView.rvAlerts.adapter = alertAdapter
    }


}