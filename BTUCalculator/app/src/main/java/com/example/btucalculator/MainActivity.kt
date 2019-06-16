package com.example.btucalculator

import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var pessoasText: TextView
    private lateinit var areaText: TextView
    private lateinit var btuText: TextView
    private lateinit var pessoasSeek: SeekBar
    private lateinit var areaSeek: SeekBar
    private lateinit var luzSolarCheck: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart(){
        super.onStart()
        bindComponents()
        bindEventHandlers()
        initializaValues()
    }

    private fun initializaValues() {
        pessoasSeek.progress = 1
        areaSeek.progress = 10
    }

    private fun bindComponents() {
        pessoasText = findViewById(R.id.pessoas_text)
        areaText = findViewById(R.id.area_text)
        btuText = findViewById(R.id.BTU_text)
        pessoasSeek = findViewById(R.id.pessoas_seek)
        areaSeek = findViewById(R.id.area_seek)
        luzSolarCheck = findViewById(R.id.luz_solar_checkbox)
    }

    private fun bindEventHandlers() {
        pessoasSeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                updatePessoas(progress)
                updateBTU(areaSeek.progress, pessoasSeek.progress)
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {}

            override fun onStartTrackingTouch(p0: SeekBar?) {}
        })

        areaSeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                updateArea(progress)
                updateBTU(areaSeek.progress, pessoasSeek.progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

        luzSolarCheck.setOnCheckedChangeListener{ compoundButton: CompoundButton, checked: Boolean ->
            updateBTU(areaSeek.progress, pessoasSeek.progress)
        }
    }

    private fun updateArea(area: Int) {
        areaText.text = String.format("%d m²", area)
    }

    private fun updateBTU(area: Int, pessoas: Int) {
        val P = if(pessoas == 0) 0 else pessoas - 1
        val B = if(luzSolarCheck.isChecked) 800 else 600
        btuText.text = String.format("%d BTU",(B*(area+P)))
    }

    private fun updatePessoas(pessoas: Int) {
        pessoasText.text = pessoas.toString()
    }


}
