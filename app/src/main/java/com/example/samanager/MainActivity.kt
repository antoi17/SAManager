package com.example.samanager

import android.content.Context
import android.database.DataSetObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.serie_list_view)
        listView.adapter = DataAdapter(this)
        listView.visibility = View.INVISIBLE

        val tabs = findViewById<TabLayout>(R.id.Tabs)
        val serietab = findViewById<TabItem>(R.id.serieTab)
        val scantab = findViewById<TabItem>(R.id.scanTab)
        val txt = findViewById<TextView>(R.id.textView)

        val floattingButton = findViewById<FloatingActionButton>(R.id.floating_action_button_add)

        floattingButton.setOnClickListener{
            txt.text = "button triggerd"
        }



        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    txt.text = tab.text
                    when {
                        tab.text!!.equals("Séries") -> {
                            txt.text = tab.text
                            listView.visibility = View.VISIBLE
                        }
                        tab.text!!.equals("Scans") -> {
                            txt.text = "Scans"
                        }
                        else -> {
                            txt.text = "Erreur"
                        }
                    }
                }
                else {
                    txt.text = "Erreur"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    txt.text = tab.text
                    when {
                        tab.text!!.equals("Séries") -> {
                            listView.visibility = View.INVISIBLE
                        }
                        tab.text!!.equals("Scans") -> {
                            txt.text = "Scans"
                        }
                        else -> {
                            txt.text = "Erreur"
                        }
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    txt.text = tab.text
                }
            }

        })

    }



}
