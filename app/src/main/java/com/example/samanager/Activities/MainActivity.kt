package com.example.samanager.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.MutableLiveData
import com.example.samanager.Enum.TypeOfData
import com.example.samanager.R
import com.example.samanager.Objects.DataItem
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout





class MainActivity() : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var datas = mutableListOf<DataItem>()
        val nbLiveData: MutableLiveData<Int> = MutableLiveData()
        nbLiveData.value = 0


        // Tabs
        val tabs = findViewById<TabLayout>(R.id.Tabs)



        //===============================================================
        //Serie tab
        //===============================================================

        //RecyclerView


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
        val divider1 = findViewById<View>(R.id.divider1)

        val textInLayout = findViewById<TextInputLayout>(R.id.TextInputLayout)
        val textIn = findViewById<TextInputEditText>(R.id.TextInputEditText)

        //Section Type
        val textSection2 = findViewById<TextView>(R.id.sectionTypeTextView)
        val divider2 = findViewById<View>(R.id.divider2)

        val TypeRadioGrp = findViewById<RadioGroup>(R.id.TypeRadioGrp)
        val SerieRadioButton = findViewById<RadioButton>(R.id.TypeSerieRadioBt)
        val ScanRadioButton = findViewById<RadioButton>(R.id.TypeScanRadioBt)

        //Section Nombre
        val textSection3 = findViewById<TextView>(R.id.sectionNBTextView)
        val divider3 = findViewById<View>(R.id.divider3)

        val txtNbSerie = findViewById<TextView>(R.id.NBSerieTextView)
        val nb = findViewById<TextView>(R.id.NB)
        val imgUp = findViewById<ImageView>(R.id.NBSerieImageViewUp)
        val imgDown = findViewById<ImageView>(R.id.NBSerieImageViewDown)

        /*val txtNbSerie = findViewById<TextView>(R.id.sectionNBTextView)
        val SerieRadioButton = findViewById<RadioButton>(R.id.TypeSerieRadioBt)
        val SerieRadioButton = findViewById<RadioButton>(R.id.TypeSerieRadioBt)*/


        //Boutton Ajouter
        val addButton = findViewById<Button>(R.id.AddButon)


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


        //Floating Bouton ajout dans bdd
        floattingButton.setOnClickListener {
            txt.text = "button triggerd"
        }

        //Bouton flèche up
        imgUp.setOnClickListener{
            nb.text = (nb.text.toString().toInt() +1).toString()
        }

        imgDown.setOnClickListener{
            if (!(nb.text=="0"))
                nb.text = (nb.text.toString().toInt() -1).toString()

        }

        //Bouton ajout
        addButton.setOnClickListener {
            var isNameOk = false
            var isTypeOk = false

            //Récupération/Vérification du nom
            var name: String = textIn.text.toString()

            if (textIn.text.toString() != "") {
                isNameOk = true
            }

            //Récupération/Vérification du Type
            var type: TypeOfData

            if (SerieRadioButton.isChecked) {
                type = TypeOfData.serie
                isTypeOk = true
            }
            else if (ScanRadioButton.isChecked) {
                type = TypeOfData.scan
                isTypeOk = true
            }
            else {
                type = TypeOfData.unknown
            }


            //Action a effectuer
            if (isNameOk && isTypeOk) {
                MaterialAlertDialogBuilder(this,
                R.style.ThemeOverlay_MaterialComponents_Light)
                    .setTitle("Confirmation")
                    .setMessage("Confirmez les choix")
                    .setPositiveButton("Confirmer") { dialog, wich ->
                        datas.add(DataItem(name, "ide", type))
                        Toast.makeText(this,"Création...", Toast.LENGTH_LONG).show()
                        textIn.setText("")
                    }
                    .setNegativeButton("Annuler") {dialog, wich ->

                    }
                    .show()
            }
            else if (!isNameOk && !isTypeOk)
            {
                Toast.makeText(this, "Choisissez un nom et un type", Toast.LENGTH_SHORT).show()
            }
            else if(!isNameOk) {
                Toast.makeText(this, "Choisissez un nom", Toast.LENGTH_SHORT).show()
            }
            else if(!isTypeOk) {
                Toast.makeText(this, "Choisissez un type", Toast.LENGTH_SHORT).show()
            }



        }


        //Selection des onglets
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    txt.text = tab.text
                    when {

                        tab.text!!.equals("Séries") -> {
                            txt.text = tab.text

                        }

                        tab.text!!.equals("Scans") -> {
                            txt.text = "Scans"
                        }

                        tab.text!!.equals("Add") -> {
                            txt.text = "Add"
                            floattingButton.visibility = View.INVISIBLE


                            textSection1.visibility = View.VISIBLE
                            divider1.visibility = View.VISIBLE
                            textIn.visibility = View.VISIBLE
                            textInLayout.visibility = View.VISIBLE

                            textSection2.visibility = View.VISIBLE
                            divider2.visibility = View.VISIBLE
                            TypeRadioGrp.visibility = View.VISIBLE

                            textSection3.visibility = View.VISIBLE
                            divider3.visibility = View.VISIBLE

                            txtNbSerie.visibility = View.VISIBLE
                            imgUp.visibility = View.VISIBLE
                            imgDown.visibility =View.VISIBLE

                            addButton.visibility = View.VISIBLE

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
                        }

                        tab.text!!.equals("Scans") -> {
                            txt.text = "Scans"
                        }

                        tab.text!!.equals("Add") -> {

                            txt.text = "Add"
                            floattingButton.visibility = View.VISIBLE

                            textSection1.visibility = View.INVISIBLE
                            divider1.visibility = View.INVISIBLE
                            textIn.visibility = View.INVISIBLE
                            textInLayout.visibility = View.INVISIBLE

                            textSection2.visibility = View.INVISIBLE
                            divider2.visibility = View.INVISIBLE
                            TypeRadioGrp.visibility = View.INVISIBLE

                            textSection3.visibility = View.INVISIBLE
                            divider3.visibility = View.INVISIBLE
                            txtNbSerie.visibility = View.INVISIBLE
                            imgUp.visibility = View.INVISIBLE
                            imgDown.visibility =View.INVISIBLE

                            addButton.visibility = View.INVISIBLE

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
