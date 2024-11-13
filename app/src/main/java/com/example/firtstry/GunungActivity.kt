package com.example.firtstry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GunungActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.gunung)
        supportActionBar?.hide()

        val buttonGoBack: Button = findViewById(R.id.goback)
        buttonGoBack.setOnClickListener {
            val intent1 = Intent (this, AplikasiActivity::class.java)
            startActivity(intent1)
        }
    }
}