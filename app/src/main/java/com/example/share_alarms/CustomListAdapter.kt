package com.example.share_alarms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

// Asegúrate de que ItemData sea una clase que refleje la estructura de tus datos
class ItemData(val text: String, val isChecked: Boolean)

class CustomListAdapter(
    context: Context,
    private val data: List<ItemData>
) : ArrayAdapter<ItemData>(context, R.layout.row_item, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        }

        val item = data[position]

        // Configura los elementos de la fila
        val iconImageView = itemView?.findViewById<ImageView>(R.id.iconImageView)
        val textTextView = itemView?.findViewById<TextView>(R.id.textTextView)
        val switchToggle = itemView?.findViewById<Switch>(R.id.switchToggle)

        // Asegúrate de que los IDs de los elementos coincidan con los de tu layout 'row_item.xml'

        textTextView?.text = item.text
        switchToggle?.isChecked = item.isChecked

        // Configura el evento de cambio para el switch (si es necesario)
        switchToggle?.setOnCheckedChangeListener { _, isChecked ->
            // Realiza acciones en función del cambio de estado del switch
            // Puedes acceder a `item` para obtener información sobre la fila correspondiente
        }

        return itemView!!
    }
}

