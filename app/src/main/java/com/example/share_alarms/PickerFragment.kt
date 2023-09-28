package com.example.share_alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class PickerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_picker, container, false)

        // Obtener referencia al AutoCompleteTextView
        val autoCompleteTextView = view.findViewById<AutoCompleteTextView>(R.id.dropdown_menu)

        // Obtener el array de recursos y configurar un adaptador
        val simpleItems = resources.getStringArray(R.array.simple_items)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, simpleItems)

        // Establecer el adaptador en el AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter)

        // Obtener referencias a los botones
        val cancelButton = view.findViewById<Button>(R.id.cancelar)
        val crearButton = view.findViewById<Button>(R.id.crear)

        // Configurar el clic del botón "Cancelar" para navegar de vuelta a fragment_listado
        cancelButton.setOnClickListener {
            findNavController().navigate(R.id.nav_host_fragment)

        }

        // Configurar el clic del botón "Crear" para mostrar un mensaje Toast
        crearButton.setOnClickListener {
            Toast.makeText(requireContext(), "La alarma fue creada con éxito", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
