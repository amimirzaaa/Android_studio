package com.example.firtstry

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Overlay

class map : AppCompatActivity() {
    private lateinit var mapView: MapView
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Memuat konfigurasi osmdroid
        Configuration.getInstance()
            .load(this, android.preference.PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(R.layout.activity_map)
        supportActionBar?.title = "Peta"

        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)
        buttonGoBack.setOnClickListener {
            val intent1 = Intent (this, AplikasiActivity::class.java)
            startActivity(intent1)
        }

        // Inisialisasi MapView
        mapView = findViewById(R.id.mapView)
        mapView.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)
        mapView.setMultiTouchControls(true)

        // Inisialisasi FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Mendapatkan lokasi saat ini
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                1
            )
        } else {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    // Ubah koordinat ke Jogja
                    val userLocation = GeoPoint(-7.776622016604673, 110.36736715827408) // Koordinat smk 2
                    mapView.controller.setZoom(15.0)
                    mapView.controller.setCenter(userLocation)

                    // Menambahkan marker di Yogyakarta
                    val marker = Marker(mapView)
                    marker.position = userLocation
                    marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    marker.title = "Yogyakarta"
                    mapView.overlays.add(marker)
                    mapView.invalidate() // Refresh peta
                }
            }
        }
    }

    private fun marker(mapView: MapView?) {

    }

    override fun onResume() {
        super.onResume()
        mapView.onResume() // Panggil onResume() untuk mapView
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause() // Panggil onPause() untuk mapView
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDetach() // Lepaskan sumber daya peta
    }
}