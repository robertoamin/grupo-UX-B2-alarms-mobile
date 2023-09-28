package com.example.share_alarms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class ContactoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contacto, container, false)
        val listView = view.findViewById<ListView>(R.id.contactListView)

        // Crear una lista de datos de ejemplo
        val data = arrayListOf(
            ItemData("Margarita Pinzon", true),
            ItemData("Andres Perez", false),
            ItemData("Julian Guevara", false),
            ItemData("Carolina Camacho", false)
        )

        // Adaptador personalizado para la lista
        val adapter = ContactListAdapter(requireContext(), data)
        listView.adapter = adapter
        // Inflate the layout for this fragment
        return view
    }


}