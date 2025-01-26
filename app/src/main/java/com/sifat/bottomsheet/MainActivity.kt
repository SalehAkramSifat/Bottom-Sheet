package com.sifat.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sifat.bottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.showBottomSheet.setOnClickListener {
            alertDialog()
        }
    }

    private fun alertDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you Sure?")
            .setMessage("Are you sure you want to proceed?")
            .setPositiveButton("Yes"){dialog, _ ->
                showBottomShet()
                dialog.dismiss()
            }
            .setNegativeButton("No"){dialog, _ ->
                dialog.dismiss()
            }
        builder.create().show()
    }
    fun showBottomShet(){
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()
    }
}