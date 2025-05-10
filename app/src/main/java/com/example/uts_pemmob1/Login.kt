package com.example.uts_pemmob1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Toast


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ensure you are using the correct library version for this
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin = findViewById<Button>(R.id.tombol_login)
        val username = findViewById<EditText>(R.id.nama_user1)
        val password = findViewById<EditText>(R.id.pass_user)

        btnLogin.setOnClickListener {
            val userInput = username.text.toString()
            val passInput = password.text.toString()

            val found = UserData.userList.any { it.username == userInput && it.password == passInput }

            if (found) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Login gagal. Cek username atau password.", Toast.LENGTH_SHORT).show()
            }
        }

        btnregisterListener()

    }

    private fun btnregisterListener() {
        val regispage1 = findViewById<TextView>(R.id.daftar)
        regispage1.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }

    data class User(val username: String, val password: String)


}
