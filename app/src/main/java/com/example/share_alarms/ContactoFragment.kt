package com.example.share_alarms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController


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

        // Obtener referencias a los botones
        val cancelContactoButton = view.findViewById<Button>(R.id.cancelarContacto)
        val asignarButton = view.findViewById<Button>(R.id.asignarContacto)

        // Configurar el clic del botón "Cancelar" para navegar de vuelta a fragment_listado
        cancelContactoButton.setOnClickListener {
            findNavController().navigate(R.id.nav_host_fragment)
        }
        // Configurar el clic del botón "Asignar" para mostrar un mensaje Toast
        asignarButton.setOnClickListener {
            Toast.makeText(requireContext(), "El(los) contacto(s) fueron asignados con exito", Toast.LENGTH_SHORT).show()
        }
        // Inflate the layout for this fragment
        return view
    }


}