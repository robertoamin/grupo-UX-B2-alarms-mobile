package com.example.share_alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

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

        return view
    }
}



