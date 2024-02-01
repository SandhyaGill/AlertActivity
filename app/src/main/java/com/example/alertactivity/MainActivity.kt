package com.example.alertactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var btnAlertDialog : Button? = null
    var btnActivity : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btnActivity = findViewById(R.id.btnActivity)

        btnAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("This is Title")
                .setCancelable(false)
                .setPositiveButton("close", {_,_->
                    Toast.makeText(this, "This is invoked from positive button", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("Negative", {_,_->
                    Toast.makeText(this, "This is invoked from negative button", Toast.LENGTH_SHORT).show()
                })
                .setNeutralButton("Neutral", {_,_->
                    Toast.makeText(this, "This is invoked from Neutral button", Toast.LENGTH_SHORT).show()
                })
                .show()

        }
        btnActivity?.setOnClickListener {
            var intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}