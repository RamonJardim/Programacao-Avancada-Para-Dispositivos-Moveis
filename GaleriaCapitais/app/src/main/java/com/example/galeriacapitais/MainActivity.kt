package com.example.galeriacapitais

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindGridHandler()
        preencherGrid()
    }

    private fun bindGridHandler() {
        gridView = findViewById(R.id.galeriaGridView)
        gridView.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val city = "${view.tag as String}, Brazil".replace(' ', '+')
            val geoIntent: Intent
               geoIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$city"))
            startActivity(geoIntent)
        }
    }

    private fun preencherGrid() {
        gridView.adapter = CartoesAdapter(this)
    }
}
