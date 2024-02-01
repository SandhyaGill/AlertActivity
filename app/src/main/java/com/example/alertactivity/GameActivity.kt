package com.example.alertactivity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    var tvABC: TextView? = null
    var btnAlertDialog: Button? = null
    var btnCustomDialog: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tvABC = findViewById(R.id.tvABC)
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btnCustomDialog = findViewById(R.id.btnCustomDialog)

        btnAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Add or Remove Alphabets")
                .setMessage(
                    "1. When you click on the Add2 button randomly any 2 Alphabets are added to your text " +
                            "2. When you click on the Add3 button randomly any 3 alphadets are added to your text " +
                            "3. when you cick on the cancle button alert dialog will be remove"
                )
                .setCancelable(false)
                .setPositiveButton("Add 2") { _, _ ->

                    val RandomNumber = List(2) {
                        Random.nextInt(65, 90)
                    }
                    var addedText = ""
                    println("RandomNumber $RandomNumber")
                    for (i in 0..<2) {
                        addedText += RandomNumber[i].toChar().toString()

                    }
                    tvABC?.setText(tvABC?.text.toString() + addedText)
                }
                .setNegativeButton("Add 3", { _, _ ->
                    val RandomNumber = List(3) {
                        Random.nextInt(65, 90)
                    }
                    var addedText = ""
                    println("RandomNumber $RandomNumber")
                    for (i in 0..2) {
                        addedText += RandomNumber[i].toChar().toString()
                    }
                    tvABC?.setText(tvABC?.text.toString() + addedText)
                })
                .setNeutralButton("Cancel") { _, _ ->
                    Toast.makeText(this, "This is invoked from Neutral button", Toast.LENGTH_SHORT)
                        .show()
                }
                .show()
        }
//        tvABC?.setText(RandomNumber.toString())
        btnCustomDialog?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.activity_custom_dialog)
            var tvUpdate = dialog.findViewById<TextView>(R.id.tvUpdate)
            var etUpdate: EditText = dialog.findViewById(R.id.etUpdate)
            var btnUpdate = dialog.findViewById<Button>(R.id.btnUpdate)

            btnUpdate?.setOnClickListener {
                if (etUpdate.text.toString().trim().isNullOrEmpty()) {
                    etUpdate.error = "Enter something"
                } else {
                    tvABC?.text =etUpdate.text.toString()
                    dialog.cancel()
//
                }

            }
            dialog.show()

        }
    }
}