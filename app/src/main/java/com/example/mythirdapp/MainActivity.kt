package com.example.mythirdapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myViewModel: MyViewModel = ViewModelProvider(this)
            .get(MyViewModel::class.java)
        setContentView(R.layout.activity_main)

        text1.text = myViewModel.allByText()
        button1.setOnClickListener {
            val vw = layoutInflater.inflate(R.layout.mydialog, null)
            val dlg_name = vw.findViewById<EditText>(R.id.dlg_name)
            val dlg_mail = vw.findViewById<EditText>(R.id.dlg_mail)
            val dlg_age = vw.findViewById<EditText>(R.id.dlg_age)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alert")
            builder.setView(vw)
                .setPositiveButton("OK",
                    DialogInterface.OnClickListener { dialog, id ->
                        myViewModel.add(dlg_name.text.toString(),
                            dlg_mail.text.toString(),
                            dlg_age.text.toString().toInt())
                        text1.text = myViewModel.allByText()
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(this, "Canceled.",
                            Toast.LENGTH_SHORT).show()
                    })

            builder.create().show()
        }
    }
}



