package com.example.share_alarms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.CheckBox
import android.widget.TextView

// Asegúrate de que ItemData sea una clase que refleje la estructura de tus datos
class NotificationData(val text: String)

class NotificationListAdapter(
    context: Context,
    private val data: List<NotificationData>
) : ArrayAdapter<NotificationData>(context, R.layout.row_notificacion, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.row_notificacion, parent, false)
        }

        val item = data[position]

        // Configura los elementos de la fila
        val textTextView = itemView?.findViewById<TextView>(R.id.notificationTextTestView)

        // Asegúrate de que los IDs de los elementos coincidan con los de tu layout 'row_item.xml'

        textTextView?.text = item.text

        return itemView!!
    }
}

