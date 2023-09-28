package com.example.share_alarms

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listado, container, false)
        val listView = view.findViewById<ListView>(R.id.listView)

        // Crear una lista de datos de ejemplo
        val data = arrayListOf(
            ItemData("4:30AM Despertar", true),
            ItemData("5:00AM Ir al Gym", true),
            ItemData("6:00AM Desayunar", true),
            ItemData("7:00AM Llevar niños al colegio", false)
        )

        // Adaptador personalizado para la lista
        val adapter = CustomListAdapter(requireContext(), data)
        listView.adapter = adapter
        // Configura el clic del botón `_action_button` para abrir el fragmento `PickerFragment`
        val actionButton = view.findViewById<FloatingActionButton>(R.id._action_button)
        if (actionButton != null) {
            actionButton.setOnClickListener {
                navigateToPickerFragment()
            }
        } else {
            Log.e("ListadoFragment", "No se encontró la vista R.id._action_button")
        }

        return view
    }

    // Función para navegar al fragmento `fragment_picker.xml`
    private fun navigateToPickerFragment() {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, PickerFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
