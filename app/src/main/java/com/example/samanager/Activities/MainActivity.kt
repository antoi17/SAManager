package com.example.samanager.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.samanager.R
import com.example.samanager.SerieDataAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //List View
        val listView = findViewById<ListView>(R.id.serie_list_view)
        listView.adapter = SerieDataAdapter(this)
        listView.visibility = View.INVISIBLE

        // Tabs
        val tabs = findViewById<TabLayout>(R.id.Tabs)
        val serietab = findViewById<TabItem>(R.id.serieTab)
        val scantab = findViewById<TabItem>(R.id.scanTab)

        //Text
        val txt = findViewById<TextView>(R.id.textView)

        //Floating Button
        val floattingButton = findViewById<FloatingActionButton>(R.id.floating_action_button_add)

        floattingButton.setOnClickListener{
            txt.text = "button triggerd"
            val intent = Intent(this, MainActivity2::class.java).apply {
                //putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
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
