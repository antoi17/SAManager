package com.example.samanager.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.samanager.R
import com.example.samanager.TypeOfData
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity2 : AppCompatActivity() {

    lateinit var name_to_add: String
    lateinit var type_to_add: TypeOfData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val textdeb = findViewById<TextView>(R.id.textdeb) // to delete used for debug

        val bouton_ajouter = findViewById<Button>(R.id.button_add2)

        val textInLayout = findViewById<TextInputLayout>(R.id.text_in)
        val text = findViewById<TextInputEditText>(R.id.name_input)

        val radioGroup = findViewById<RadioGroup>(R.id.radiogroup)
        val radioButtonSerie = findViewById<RadioButton>(R.id.radioButton_serie)
        val radioButtonScan = findViewById<RadioButton>(R.id.radioButton_scan)

        bouton_ajouter.setOnClickListener {
            name_to_add = text.text.toString()
            if (radioButtonScan.isChecked) {
                type_to_add = TypeOfData.scan
            } else {
                type_to_add = TypeOfData.serie

            }

            textdeb.text = type_to_add.toString()

            MaterialAlertDialogBuilder(
                this,
                R.style.ThemeOverlay_MaterialComponents_Light
            )
                .setTitle("Confirmation de l'ajout")
                .setMessage("Test")
                .setNegativeButton("Annuler") { _, _ ->
                    // Respond to negative button press
                }
                .setPositiveButton("Confirmer") { _, _ ->
                    // Respond to positive button press
                }
                .show()
        }
    }
}