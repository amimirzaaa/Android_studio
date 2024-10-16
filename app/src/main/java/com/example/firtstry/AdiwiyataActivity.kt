package com.example.firtstry

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AdiwiyataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.adiwiyata)
        supportActionBar?.title = "Adiwiyata"

        val buttonGoBack: Button = findViewById(R.id.button3)
        buttonGoBack.setOnClickListener {
            val intent1 = Intent (this, AplikasiActivity::class.java)
            startActivity(intent1)
        }
    }
}