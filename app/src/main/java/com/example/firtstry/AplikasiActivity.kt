package com.example.firtstry

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AplikasiActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.aplikasi)
        supportActionBar?.title = "Aplikasi"

        val scan1 = findViewById<ImageView>(R.id.scanQR)
        scan1.setOnClickListener {
            val intent1 = Intent (this, ScanActivity::class.java)
            startActivity(intent1)
        }

        val lokasi = findViewById<ImageView>(R.id.lokasi)
        lokasi.setOnClickListener {
            val intent2 = Intent (this, map::class.java)
            startActivity(intent2)
        }

        val kalku = findViewById<ImageView>(R.id.cal)
        kalku.setOnClickListener {
            val intent3 = Intent (this, MainActivity2::class.java)
            startActivity(intent3)
        }

        val adiwiyata = findViewById<ImageView>(R.id.adw)
        adiwiyata.setOnClickListener {
            val intent4 = Intent (this, AdiwiyataActivity::class.java)
            startActivity(intent4)
        }

        val gunung = findViewById<ImageView>(R.id.gun)
        gunung.setOnClickListener {
            val intent5 = Intent (this, GunungActivity::class.java)
            startActivity(intent5)
        }

        val kul = findViewById<ImageView>(R.id.kuli)
        kul.setOnClickListener {
            val intent6 = Intent (this, kuliner::class.java)
            startActivity(intent6)
        }
    }
}