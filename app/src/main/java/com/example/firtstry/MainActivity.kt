package com.example.firtstry
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportActionBar?.title="Home"


        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            val intent1 = Intent (this, AplikasiActivity::class.java)
            startActivity(intent1)
        }
    }
}