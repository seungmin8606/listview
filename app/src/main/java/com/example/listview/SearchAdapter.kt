/*package com.example.listview

import android.widget.TextView
import android.R
import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.BaseAdapter


class SearchAdapter(val list: List<String>, context: Context) : BaseAdapter() {
    val context: Context
    val inflate: LayoutInflater
    private var viewHolder: ViewHolder? = null
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): Any {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.row_listview, null)
            viewHolder = ViewHolder()
            viewHolder!!.label = convertView.findViewById(R.id.label)
            convertView.setTag(viewHolder)
        } else {
            viewHolder = convertView.getTag()
        }

        viewHolder!!.label!!.text = list[position]
        return convertView
    }

    internal inner class ViewHolder {
        var label: TextView? = null
    }

    init {
        this.context = context
        inflate = LayoutInflater.from(context)
    }
}*/