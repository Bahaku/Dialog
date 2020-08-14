package com.example.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessControlContext

class CustomDialog(context: Context): Dialog(context) {
    private var btnExit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        window?.setBackgroundDrawableResource(R.drawable.icon)
        setCancelable(false)
        setupViews()
        listeners()
    }

    private fun setupViews(){
        btnExit = findViewById(R.id.btnExit)
    }

    private fun listeners(){
        btnExit?.setOnClickListener{
            dismiss()
        }
    }
}