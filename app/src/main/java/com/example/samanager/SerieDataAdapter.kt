package com.example.samanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

public class
SerieDataAdapter(context: Context) : BaseAdapter(){

    private val mContext: Context = context
    private val layoutInflater: LayoutInflater = LayoutInflater.from(mContext)

    private val data = arrayListOf<SerieDataCollection>(
        SerieDataCollection("OnePiece", "OP15"),
        SerieDataCollection("Bleach", "B70")
    )

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return "Test string"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val row = layoutInflater.inflate(R.layout.listview_row, parent, false)


        val name = row.findViewById<TextView>(R.id.textView_names)
        name.text = "Name: " + data[position].name

        val number = row.findViewById<TextView>(R.id.textView_number)
        number.text = "Nb d'épisodes: " + data[position].nb.lastIndex.toString()

        return row

    }


}
