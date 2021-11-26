package com.example.samanager.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.example.samanager.R
import com.example.samanager.SerieDataAdapter
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tabs
        val tabs = findViewById<TabLayout>(R.id.Tabs)



        //===============================================================
        //Serie tab
        //===============================================================

        //List View
        val listView = findViewById<ListView>(R.id.serie_list_view)
        listView.adapter = SerieDataAdapter(this)
        listView.visibility = View.INVISIBLE

        //tab
        val serietab = findViewById<TabItem>(R.id.serieTab)



        //===============================================================
        //Serie Scan
        //===============================================================

        //tab
        val scantab = findViewById<TabItem>(R.id.scanTab)



        //===============================================================
        //Serie Add
        //===============================================================
        //tab
        val addTab = findViewById<TabItem>(R.id.addTab)

        //Section text
        val textSection1 = findViewById<TextView>(R.id.sectionNomTextview)
        val textInLayout = findViewById<TextInputLayout>(R.id.TextInputLayout)
        val textIn = findViewById<TextInputEditText>(R.id.TextInputEditText)

        //Section Type
        val textSection2 = findViewById<TextView>(R.id.sectionTypeTextView)
        val TypeRadioGrp = findViewById<RadioGroup>(R.id.TypeRadioGrp)
        val SerieRadioButton = findViewById<RadioButton>(R.id.TypeSerieRadioBt)
        val ScanRadioButton = findViewById<RadioButton>(R.id.TypeScanRadioBt)






        //===============================================================
        //Communs
        //===============================================================

        //Text
        val txt = findViewById<TextView>(R.id.textView)

        //Floating Button
        val floattingButton = findViewById<FloatingActionButton>(R.id.floating_action_button_add)


        //===============================================================
        //OnclickListener
        //===============================================================

        //Bouton ajout dans bdd
        floattingButton.setOnClickListener{
            txt.text = "button triggerd"


            /*val singleItems = arrayOf("Item 1", "Item 2", "Item 3")
            val checkedItem = 1
            MaterialAlertDialogBuilder(this)
                // Add customization options here
                .setTitle("Ajouter")
                .setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->
                    // Respond to item chosen
                }
                .show()*/
        }



        textSection2.setOnClickListener{
            txt.text = "text triggerd"
        }
        //Selection des onglets
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

                        tab.text!!.equals("Add") -> {
                            txt.text = "Add"
                            textSection1.visibility = View.VISIBLE
                            textIn.visibility = View.VISIBLE
                            textInLayout.visibility = View.VISIBLE
                            textSection2.visibility = View.VISIBLE
                            TypeRadioGrp.visibility = View.VISIBLE

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


            //Deselection des onglets
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

                        tab.text!!.equals("Add") -> {

                            txt.text = "Add"
                            textSection1.visibility = View.INVISIBLE
                            textIn.visibility = View.INVISIBLE
                            textInLayout.visibility = View.INVISIBLE
                            textSection2.visibility = View.INVISIBLE
                            TypeRadioGrp.visibility = View.INVISIBLE
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
