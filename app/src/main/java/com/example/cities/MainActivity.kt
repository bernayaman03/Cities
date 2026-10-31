package com.example.cities

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 1. Tanımlamalar
    private lateinit var imageView: ImageView
    private lateinit var tvSehirIsim: TextView
    private lateinit var tvPlaka: TextView
    private lateinit var tvOzet: TextView
    private lateinit var btnGeri: ImageButton
    private lateinit var btnIleri: ImageButton


    private val resimler = listOf(R.drawable.mage1, R.drawable.mage2, R.drawable.mage3)
    private val isimler = listOf("İstanbul", "Ankara", "İzmir")
    private val plakalar = listOf("34", "06", "35")
    private val ozetler = listOf("Boğazın incisi...", "Başkentimiz...", "Egenin kalbi...")

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. Bağlama
        imageView = findViewById(R.id.imageView)
        tvSehirIsim = findViewById(R.id.tvSehirIsim)
        tvPlaka = findViewById(R.id.tvPlaka)
        tvOzet = findViewById(R.id.tvOzet)
        btnGeri = findViewById(R.id.btnGeri)
        btnIleri = findViewById(R.id.btnIleri)

        updateUI() // İlk açılışta verileri yükle

        // 3. İleri Butonu
        btnIleri.setOnClickListener {
            if (index < resimler.size - 1) {
                index++
                updateUI()
            }
        }

        // 4. Geri Butonu
        btnGeri.setOnClickListener {
            if (index > 0) {
                index--
                updateUI()
            }
        }
    }


    private fun updateUI() {
        imageView.setImageResource(resimler[index])
        tvSehirIsim.text = isimler[index]
        tvPlaka.text = plakalar[index]
        tvOzet.text = ozetler[index]

        
        btnGeri.visibility = if (index == 0) View.INVISIBLE else View.VISIBLE
        btnIleri.visibility = if (index == resimler.size - 1) View.INVISIBLE else View.VISIBLE
    }
}