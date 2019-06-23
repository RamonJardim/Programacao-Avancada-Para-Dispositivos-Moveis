package com.example.galeriacapitais

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import modelos.Cartao

class CartoesAdapter(private val contexto: Context): BaseAdapter() {

    private val cartoes =
        arrayOf(
            Cartao(R.drawable.am, "Amazonas"),
            Cartao(R.drawable.ba, "Bahia"),
            Cartao(R.drawable.df, "Distrito Federal"),
            Cartao(R.drawable.ma, "Maranhão"),
            Cartao(R.drawable.mg, "Minas Gerais"),
            Cartao(R.drawable.mt, "Mato grosso"),
            Cartao(R.drawable.pe, "Pernabuco"),
            Cartao(R.drawable.pi, "Piauí"),
            Cartao(R.drawable.pr, "Paraná"),
            Cartao(R.drawable.rj, "Rio de Janeiro"),
            Cartao(R.drawable.rs, "Rio Grande do Sul"),
            Cartao(R.drawable.sp, "São Paulo"))

    override fun getCount(): Int {
        return cartoes.size
    }

    override fun getItemId(posicao: Int): Long {
        return 0
    }

    override fun getItem(posicao: Int): Any? {
        return null
    }

    override fun getView(posicao: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView

        if (convertView == null) {
            imageView = ImageView(contexto)
            imageView.layoutParams = ViewGroup.LayoutParams(
                contexto.resources.getDimensionPixelSize(R.dimen.image_view_grid_width),
                contexto.resources.getDimensionPixelSize(R.dimen.image_view_grid_width))
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else
            imageView = convertView as ImageView

        imageView.setImageResource(cartoes[posicao].idImagem)
        imageView.tag = cartoes[posicao].local

        return imageView
    }

}

