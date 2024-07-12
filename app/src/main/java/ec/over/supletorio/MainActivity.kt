package ec.over.supletorio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var saldoTextView: TextView
    private lateinit var amountEditText: EditText
    private lateinit var depositButton: Button
    private lateinit var withdrawButton: Button
    private var saldo: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saldoTextView = findViewById(R.id.saldoTextView)
        amountEditText = findViewById(R.id.amountEditText)
        depositButton = findViewById(R.id.depositButton)
        withdrawButton = findViewById(R.id.withdrawButton)

        depositButton.setOnClickListener { depositMoney() }
        withdrawButton.setOnClickListener { withdrawMoney() }
    }

    private fun depositMoney() {
        val amountStr = amountEditText.text.toString()
        if (amountStr.isNotEmpty()) {
            val amount = amountStr.toDouble()
            saldo += amount
            updateSaldoTextView()
            amountEditText.setText("")
        }
    }

    private fun withdrawMoney() {
        val amountStr = amountEditText.text.toString()
        if (amountStr.isNotEmpty()) {
            val amount = amountStr.toDouble()
            if (saldo >= amount) {
                saldo -= amount
                updateSaldoTextView()
                amountEditText.setText("")
            } else {
                Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateSaldoTextView() {
        saldoTextView.text = "Saldo: $" + String.format("%.2f", saldo)
    }
}