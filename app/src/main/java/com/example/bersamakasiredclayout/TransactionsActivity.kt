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
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


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
        }

    }
}
