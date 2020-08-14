package com.example.dialog
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    private var dateOfBirth: EditText? = null
    private var lastName: EditText? = null
    private var firstName: EditText? = null
    private var btn: Button? = null
    private var btnSave: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        listeners()

    }

    private  fun setupViews() {
        dateOfBirth = findViewById(R.id.dateOfBirth)
        lastName = findViewById(R.id.lastName)
        firstName = findViewById(R.id.firstName)
        btn = findViewById(R.id.btn)
        btnSave = findViewById(R.id.btnSave)
    }

    private fun listeners() {
        dateOfBirth?.setOnClickListener{
            createDatePickerDialog()
        }
        btnSave?.setOnClickListener{
            createAlertDialog()

        }
    }

    private fun createDatePickerDialog() {
       val dialog = DatePickerDialog(this)
        dialog.setOnDateSetListener { view, year: Int, month: Int, dayOfMonth: Int ->
           dateOfBirth?.setText(getString(R.string.date, dayOfMonth, month, year))
        }
        dialog.datePicker.maxDate = Date().time
        dialog.show()
    }
    private fun createCustomDialog() {
        CustomDialog(this).show()
    }

    private fun createAlertDialog() {
        val alertDialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.myDialog))
        alertDialog.setTitle("Сохранить данные?")
        alertDialog.setPositiveButton("Да") { dialog, which -> getShared() }
        alertDialog.setNegativeButton("Нет") {dialog, which -> finish()}
        alertDialog.show()
    }
    private fun getShared(){
        val pref = getSharedPreferences("Pref", Context.MODE_PRIVATE)
        val pref1 = getSharedPreferences("pref1", Context.MODE_PRIVATE)
        val name = lastName?.editableText.toString()
        val name1 = firstName?.editableText.toString()
        pref.edit().putString("lastName", name).apply()
        pref1.edit().putString("firstName", name1).apply()
        CustomDialog(this).show()
    }


}