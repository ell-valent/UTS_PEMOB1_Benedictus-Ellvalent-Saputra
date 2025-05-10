package com.example.uts_pemmob1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Toast



class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = findViewById<EditText>(R.id.nama_user2)
        val pass = findViewById<EditText>(R.id.pass_user1)
        val pass2 = findViewById<EditText>(R.id.pass_user2)
        val btnRegister = findViewById<Button>(R.id.tombol_register)

        btnRegister.setOnClickListener {
            val user = username.text.toString()
            val pw1 = pass.text.toString()
            val pw2 = pass2.text.toString()

            if (user.isBlank() || pw1.isBlank() || pw2.isBlank()) {
                Toast.makeText(this, "Username harus diisi", Toast.LENGTH_SHORT).show()
            } else if (pw1 != pw2) {
                Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
            } else {
                UserData.userList.add(User(user, pw1))
                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Login::class.java))
                finish()
            }
        }

        btnbackregisterListener()
        btnbackgologinListener()
    }
    private fun btnbackregisterListener() {
        val icback = findViewById<ImageView>(R.id.tombol_back)
        icback.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
    private fun btnbackgologinListener() {
        val gologin1 = findViewById<TextView>(R.id.gologin1)
        gologin1.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }

}