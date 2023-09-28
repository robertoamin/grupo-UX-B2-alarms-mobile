package com.example.share_alarms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class NotificacionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notificacion, container, false)
        val listView = view.findViewById<ListView>(R.id.notificationListView)

        // Crear una lista de datos de ejemplo
        val data = arrayListOf(
            NotificationData("1. Pedro acepto el evento"),
            NotificationData("2. Se agrego nuevo tono"),
            NotificationData("3. Imagen Modificada"),
            NotificationData("4. Eliminaste tono barracuda")
        )

        // Adaptador personalizado para la lista
        val adapter = NotificationListAdapter(requireContext(), data)
        listView.adapter = adapter
        // Inflate the layout for this fragment
        return view
    }


}