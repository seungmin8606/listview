package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filterable
import android.widget.TextView

class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: List<Room>
) : ArrayAdapter<Room>(mContext, resId, mList), Filterable {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }
        val row = tempRow!!

        val data = mList[position]
        val wine = row.findViewById<TextView>(R.id.wineText)
        val wineEN = row.findViewById<TextView>(R.id.EnText)
        val winery = row.findViewById<TextView>(R.id.wineryText)
        val price = row.findViewById<TextView>(R.id.priceText)

        wine.text = data.wineName
        wineEN.text = data.wineEN
        winery.text = "${data.companyKR} / ${data.companyEN}"
        price.text = "${data.price}원."

        return row
    }
}
