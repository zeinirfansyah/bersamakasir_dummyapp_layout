package com.example.bersamakasiredclayout

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView


class TransactionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transactions)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack: ImageView = findViewById(R.id.btn_back)
        val btnBluetoothList: ImageView = findViewById(R.id.bt_bluetoothList)
        val btnBayar: Button = findViewById(R.id.btn_bayar)


        btnBack.setOnClickListener {
            finish()
        }

        btnBluetoothList.setOnClickListener {
            intent = Intent(this, BluetoothListActivity::class.java)
            startActivity(intent)
        }

        btnBayar.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.custom_dialog_payment_method, null)
            val dialogPaymentMethod = Dialog(this)
            dialogPaymentMethod.setContentView(dialogBinding)

            dialogPaymentMethod.setCancelable(true)

            val window = dialogPaymentMethod.window
            if (window != null) {
                window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                val params = window.attributes
                params.width = WindowManager.LayoutParams.MATCH_PARENT
                params.gravity = Gravity.BOTTOM
                window.attributes = params
            }

            dialogPaymentMethod.show()

            val ivEdc: ImageView = dialogBinding.findViewById(R.id.iv_edc)

            ivEdc.setOnClickListener {
                // Inflate the sub-dialog layout
                val subDialogBinding = layoutInflater.inflate(R.layout.custom_dialog_payment_submethod, null)
                val subDialogPaymentMethod = Dialog(this)
                subDialogPaymentMethod.setContentView(subDialogBinding)
                subDialogPaymentMethod.setCancelable(true)

                val window2 = subDialogPaymentMethod.window
                if (window2 != null) {
                    val params = window2.attributes
                    params.width = WindowManager.LayoutParams.MATCH_PARENT
                    window2.attributes = params
                }

                subDialogPaymentMethod.show()

                val tvDebit : MaterialCardView = subDialogBinding.findViewById(R.id.tv_debit)
                val tvQris : MaterialCardView = subDialogBinding.findViewById(R.id.tv_qris)
                val tvKartu : MaterialCardView = subDialogBinding.findViewById(R.id.tv_kartu)

                tvDebit.setOnClickListener {
                    subDialogPaymentMethod.dismiss()
                    dialogPaymentMethod.dismiss()
                    Toast.makeText(this, "Data sedang dikirim ke EDC...", Toast.LENGTH_SHORT).show()
                }

                tvQris.setOnClickListener {
                    subDialogPaymentMethod.dismiss()
                    dialogPaymentMethod.dismiss()
                    Toast.makeText(this, "Data sedang dikirim ke EDC...", Toast.LENGTH_SHORT).show()
                }

                tvKartu.setOnClickListener {
                    subDialogPaymentMethod.dismiss()
                    dialogPaymentMethod.dismiss()
                    Toast.makeText(this, "Data sedang dikirim ke EDC...", Toast.LENGTH_SHORT).show()
                }
            }
        }



    }
}
