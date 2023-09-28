package com.example.share_alarms

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController


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

        // Obtener referencias a los botones
        val cancelNotificacionButton = view.findViewById<Button>(R.id.cancelarNotificaciones)
        val eliminarButton = view.findViewById<Button>(R.id.borrarNotificaciones)

        // Configurar el clic del botón "Cancelar" para navegar de vuelta a fragment_listado
        cancelNotificacionButton.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)

        }
        // Configurar el clic del botón "Eliminar"
        eliminarButton.setOnClickListener {
            val data = arrayListOf(
                NotificationData("Notificaciones Eliminadas!!!!"),
                NotificationData(""),
                NotificationData(""),
                NotificationData("")
            )
            val adapter = NotificationListAdapter(requireContext(), data)
            listView.adapter = adapter

            Toast.makeText(requireContext(), "Las notificaciones han sido eliminadas", Toast.LENGTH_SHORT).show()
        }

        // Inflate the layout for this fragment
        return view
    }



}