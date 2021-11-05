package com.example.samanager

import android.content.Context
import android.database.DataSetObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view)

        listView.adapter = DataAdapter(this)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    private class DataAdapter(context: Context) : BaseAdapter(){

        private val mContext: Context
        private val data = arrayListOf<DataCollection>(
            DataCollection("OnePiece", "OP15"),
            DataCollection("Bleach", "B70")
        )

        init {
            mContext = context
        }
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

            val layoutInflater = LayoutInflater.from(mContext)
            val row = layoutInflater.inflate(R.layout.listview_row, parent, false)

            val name = row.findViewById<TextView>(R.id.textView_names)
            name.text = data[position].name
            return row
/*


 */
        }
    }
}