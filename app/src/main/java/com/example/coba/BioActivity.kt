package com.example.coba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.app.DatePickerDialog
import android.widget.DatePicker
import java.util.*


 class BioActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var etTanggal: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        val btnSubmit:Button = findViewById(R.id.btn_submit)
        btnSubmit.setOnClickListener(this)

        etTanggal = findViewById(R.id.et_input_tanggal)
        etTanggal.setOnClickListener{
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(

                this,
                {view, year, MonthOfYear, dayOfMonth ->

                    val dat = (dayOfMonth.toString() + "-" +
                            (MonthOfYear + 1) + "-" + year)
                    etTanggal.setText(dat)
                },

                year,
                month,
                day
            )

            datePickerDialog.show()
        }
    }

     override fun onClick(v: View?) {
         when(v?.id){
             R.id.btn_submit -> {
                 val etNamaDepan : EditText = findViewById(R.id.edt_namaDepan)
                 val etNamaBelakang : EditText = findViewById(R.id.edt_namaBelakang)
                 val etTanggal : EditText = findViewById(R.id.et_input_tanggal)
                 val etAlamat : EditText = findViewById(R.id.edt_alamat)
                 val etNomor : EditText = findViewById(R.id.edt_phone)

                 val tvNama : TextView = findViewById(R.id.tv_output_nama)
                 val tvTanggal : TextView = findViewById(R.id.tv_output_tanggal)
                 val tvAlamat : TextView = findViewById(R.id.tv_output_alamat)
                 val tvNomor : TextView = findViewById(R.id.tv_output_Nomor)

                 val textNama = "Nama : ${etNamaDepan.getText().toString()} ${etNamaBelakang.getText().toString()}"
                 val textTanggal = "Tanggal Lahir: ${etTanggal.getText().toString()}"
                 val textAlamat = "Alamat: ${etAlamat.getText().toString()}"
                 val textNomor = "Nomor Telepon: ${etNomor.getText().toString()}"

                 tvNama.text = textNama
                 tvTanggal.text = textTanggal
                 tvAlamat.text = textAlamat
                 tvNomor.text = textNomor
             }
         }
     }
 }